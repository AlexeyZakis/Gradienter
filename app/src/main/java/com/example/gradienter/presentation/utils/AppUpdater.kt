package com.example.gradienter.presentation.utils

import android.content.Context
import android.content.Intent
import androidx.core.content.FileProvider
import com.example.gradienter.BuildConfig
import com.example.gradienter.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream

object AppUpdater {
    suspend fun getLatestReleaseInfo(): Pair<String, String>? {
        var latestVersion: String = ""
        var apkUrl: String = ""
        withContext(Dispatchers.IO) {
            val client = OkHttpClient()
            val latestReleaseUrl = "https://api.github.com/repos/${Constants.GITHUB_OWNER}/${Constants.GITHUB_REPOSITORY}/releases/latest"

            // Get latest release info
            val request = Request.Builder().url(latestReleaseUrl).build()
            val response = client.newCall(request).execute()

            val latestRelease = response.body?.string() ?: return@withContext null

            val json = JSONObject(latestRelease)
            latestVersion = json.getString("tag_name")
            apkUrl = json.getJSONArray("assets").getJSONObject(0).getString("browser_download_url")
        }
        return Pair(latestVersion, apkUrl)
    }

    suspend fun downloadApk(apkUrl: String, context: Context): File? {
        var apkFile: File? = null
        withContext(Dispatchers.IO) {
            val client = OkHttpClient()
            val apkRequest = Request.Builder().url(apkUrl).build()
            val apkResponse = client.newCall(apkRequest).execute()

            val inputStream = apkResponse.body?.byteStream() ?:
                return@withContext null
            apkFile = File(context.cacheDir, "latest_release.apk")
            val outputStream = FileOutputStream(apkFile)

            inputStream.copyTo(outputStream)
            outputStream.close()
            inputStream.close()
        }
        return apkFile
    }

    fun getCurrentAppVersion() = BuildConfig.VERSION_NAME

    fun installApk(context: Context, apkFile: File) {
        val apkUri = FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", apkFile)
        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(apkUri, "application/vnd.android.package-archive")
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }
}