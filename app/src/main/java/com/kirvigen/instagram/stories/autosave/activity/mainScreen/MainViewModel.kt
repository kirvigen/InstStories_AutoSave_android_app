package com.kirvigen.instagram.stories.autosave.activity.mainScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kirvigen.instagram.stories.autosave.instagramUtils.InstagramInteractor
import com.kirvigen.instagram.stories.autosave.instagramUtils.InstagramRepository
import com.kirvigen.instagram.stories.autosave.instagramUtils.data.Profile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class MainViewModel(
    private val instagramInteractor: InstagramInteractor,
    private val instagramRepository: InstagramRepository
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    val currentProfile = MutableLiveData<Profile>()

    fun loadProfile() {
        launch {
            try {
                currentProfile.postValue(instagramRepository.getCurrentProfile() ?: return@launch)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun onResume() {
        instagramInteractor.checkAndOpenAuthInstagram()
    }
}