package com.ganbaru.myprotodemoapplication.ui.userprofile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ganbaru.myprotodemoapplication.UserProfile
import com.ganbaru.myprotodemoapplication.data.userprofile.UserProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val userProfileRepository: UserProfileRepository) : ViewModel() {

    var userProfile:LiveData<UserProfile>? = null

    private val _profileUiState = MutableStateFlow(ProfileUiState())
    val profileUiState: StateFlow<ProfileUiState> = _profileUiState

    init { getUserProfile() }

    private fun getUserProfile() {
        viewModelScope.launch {
           userProfile =  userProfileRepository.getUserProfile()
        }
    }

    fun addUserProfile(userId: Int, firstName: String, lastName: String, email: String, phone: String) {
        val userProfile = UserProfile.newBuilder().setId(userId).setFirstName(firstName).setLastName(lastName).setEmail(email).setPhone(phone).build()
        viewModelScope.launch {
            userProfileRepository.addUserProfile(userProfile)
            getUserProfile()
        }
    }

    fun navigateToMain() {
        _profileUiState.update { it.copy(moveToMain = true) }
    }

    fun navigateToMainFinished() {
        _profileUiState.update { it.copy(moveToMain = false) }
    }

}