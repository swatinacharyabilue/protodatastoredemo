package com.ganbaru.myprotodemoapplication.data.userprofile

import androidx.lifecycle.LiveData
import com.ganbaru.myprotodemoapplication.UserProfile

interface UserProfileData {

    suspend fun getUserProfile(): LiveData<UserProfile>

    suspend fun addUserProfile(newUserProfile: UserProfile)

    suspend fun clearAllUserProfiles()

}