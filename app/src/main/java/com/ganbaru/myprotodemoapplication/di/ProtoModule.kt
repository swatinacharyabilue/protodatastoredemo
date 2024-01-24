package com.ganbaru.myprotodemoapplication.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.ganbaru.myprotodemoapplication.UserProfile
import com.ganbaru.myprotodemoapplication.data.userprofile.UserProfileSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProtoModule {

    private val Context.userProfileDataStore: DataStore<UserProfile> by dataStore(
        fileName = "user_profile.pb",
        serializer = UserProfileSerializer
    )

    @Provides
    @Singleton
    fun getProtoDataStore(@ApplicationContext context: Context): DataStore<UserProfile> {
        return context.userProfileDataStore
    }
}