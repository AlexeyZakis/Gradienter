package com.example.gradienter.presentation.screens.settingsScreen

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gradienter.Constants
import com.example.gradienter.R
import com.example.gradienter.data.ColorRepresentations
import com.example.gradienter.domain.usecase.settingsRepository.GetColorRepresentationUseCase
import com.example.gradienter.domain.usecase.settingsRepository.GetGradientElementSizeUseCase
import com.example.gradienter.domain.usecase.settingsRepository.SetColorRepresentationUseCase
import com.example.gradienter.domain.usecase.settingsRepository.SetGradientElementSizeUseCase
import com.example.gradienter.presentation.utils.AppUpdater
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class SettingsScreenViewModel @Inject constructor(
    @ApplicationContext private val applicationContext: Context,
    private val getColorRepresentationUseCase: GetColorRepresentationUseCase,
    private val setColorRepresentationUseCase: SetColorRepresentationUseCase,
    private val getGradientElementSizeUseCase: GetGradientElementSizeUseCase,
    private val setGradientElementSizeUseCase: SetGradientElementSizeUseCase,
) : ViewModel() {
    private val _screenState = MutableStateFlow(SettingsScreenState())
    val screenState = combine(
        _screenState,
        getGradientElementSizeUseCase(),
        getColorRepresentationUseCase()
    ) { state, gradientElementSize, colorRepresentation ->
        state.copy(
            gradientElementSize = gradientElementSize,
            colorRepresentation = colorRepresentation
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        SettingsScreenState()
    )

    fun screenAction(action: SettingsScreenAction) {
        when (action) {
            is SettingsScreenAction.OnColorRepresentationChange ->
                changeColorRepresentation(action.colorRepresentation)
            is SettingsScreenAction.OnGradientElementSizeChange ->
                changeGradientElementSize(action.gradientElementSize)
            is SettingsScreenAction.OnCurrentVersionClick ->
                openGitHubCurrentRelease(action.context)
            is SettingsScreenAction.OnNewVersionInfoClick ->
                openGitHubLatestRelease(action.context)
            is SettingsScreenAction.OnCheckNewVersionClick ->
                checkNewVersion()
            is SettingsScreenAction.OnDownloadNewVersionClick ->
                downloadNewVersion()
        }
    }

    private fun changeColorRepresentation(
        colorRepresentation: ColorRepresentations.Representation
    ) {
        setColorRepresentationUseCase(colorRepresentation)
    }
    private fun changeGradientElementSize(gradientElementSize: Int) {
        setGradientElementSizeUseCase(gradientElementSize)
    }
    private fun openGitHubCurrentRelease(context: Context) {
        openUri(
            context = context,
            uriString = Constants.GITHUB_CURRENT_RELEASE_URI
        )
    }
    private fun openGitHubLatestRelease(context: Context) {
        openUri(
            context = context,
            uriString = Constants.GITHUB_LATEST_RELEASE_URI
        )
    }
    private fun openUri(context: Context, uriString: String) {
        val intent = Intent(
            Intent.ACTION_VIEW, Uri.parse(uriString)
        )
        context.startActivity(intent)
    }
    private fun checkNewVersion() {
        viewModelScope.launch {
            val currentVersion = AppUpdater.getCurrentAppVersion()

            var latestReleaseInfo: Pair<String, String>? = null
            try {
                latestReleaseInfo = AppUpdater.getLatestReleaseInfo()
            } catch (_: Exception) {}

            if (latestReleaseInfo != null) {
                val (latestVersion, apkUrl) = latestReleaseInfo
                if (latestVersion != currentVersion) {
                    _screenState.value = _screenState.value.copy(
                        hasNewVersion = true,
                        newVersionApkUrl = apkUrl,
                        newVersionName = latestVersion,
                    )
                } else {
                    _screenState.value = _screenState.value.copy(hasNewVersion = false)
                    Toast.makeText(
                        applicationContext,
                        applicationContext.getString(R.string.noNewVersionAvailable),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    applicationContext.getString(R.string.failedToFetchLatestReleaseInfo),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun downloadNewVersion() {
        val apkUrl = _screenState.value.newVersionApkUrl
        if (apkUrl != null) {
            _screenState.value = _screenState.value.copy(isDownloading = true)
            viewModelScope.launch {
                var apkFile: File? = null
                try {
                    apkFile = AppUpdater.downloadApk(apkUrl, applicationContext)
                } catch (_: Exception) {}
                if (apkFile != null) {
                    Toast.makeText(
                        applicationContext,
                        applicationContext.getString(R.string.downloadComplete),
                        Toast.LENGTH_SHORT
                    ).show()
                    AppUpdater.installApk(applicationContext, apkFile)
                } else {
                    Toast.makeText(
                        applicationContext,
                        applicationContext.getString(R.string.downloadFailed),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                _screenState.value = _screenState.value.copy(isDownloading = false)
            }
        } else {
            Toast.makeText(
                applicationContext,
                applicationContext.getString(R.string.noNewVersionUrlFound),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
