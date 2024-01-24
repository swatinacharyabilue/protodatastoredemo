package com.ganbaru.myprotodemoapplication.data.userprofile

import androidx.datastore.core.DataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.ganbaru.myprotodemoapplication.UserProfile
import javax.inject.Inject

class UserProfileRepository @Inject constructor(private val protoDataStore: DataStore<UserProfile>):
    UserProfileData {

    override suspend fun getUserProfile(): LiveData<UserProfile> {
        return protoDataStore.data.asLiveData()
    }

    override suspend fun addUserProfile(newUserProfile: UserProfile) {
        protoDataStore.updateData { newUserProfile.toBuilder().build() }
    }

    override suspend fun clearAllUserProfiles() {
        protoDataStore.updateData { it.toBuilder().clear().build() }
    }

}