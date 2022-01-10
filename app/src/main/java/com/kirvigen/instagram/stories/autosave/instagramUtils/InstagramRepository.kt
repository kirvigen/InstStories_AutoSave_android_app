package com.kirvigen.instagram.stories.autosave.instagramUtils

import com.kirvigen.instagram.stories.autosave.instagramUtils.data.Profile
import com.kirvigen.instagram.stories.autosave.instagramUtils.data.Stories
import com.kirvigen.instagram.stories.autosave.utils.MyResult

interface InstagramRepository {

    suspend fun getStories(userId: Long): List<Stories>

    fun getInstagramCookies(): String

    suspend fun getFollowers(): List<Profile>

    suspend fun getCurrentProfile(): Profile?

    suspend fun getUserId(nickname: String): MyResult
}