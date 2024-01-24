package com.ganbaru.myprotodemoapplication.ui.userprofile

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.lifecycleScope
import com.ganbaru.myprotodemoapplication.R
import com.ganbaru.myprotodemoapplication.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserProfileActivity : ComponentActivity() {

    private val profileViewModel by viewModels<ProfileViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainProfileScreen(profileViewModel) }
        lifecycleScope.launch {
            profileViewModel.profileUiState.collect { uiState ->
                if (uiState.moveToMain) {
                    startActivity(Intent(baseContext, MainActivity::class.java))
                    profileViewModel.navigateToMainFinished()
                    finish()
                }
            }
        }
    }
}

@Composable
fun MainProfileScreen(profileViewModel: ProfileViewModel) {
    ShowWelcomeScreen()
    val userProfile = profileViewModel.userProfile?.observeAsState()
    if (userProfile?.value == null) {
        profileViewModel.addUserProfile(
            1,
            "Random",
            "Name",
            "swatinacharya@gmail.com",
            "0411101457"
        )
    }
    profileViewModel.navigateToMain()
}

@Composable
fun ShowWelcomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.colorPrimaryDark)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Welcome")
    }
}



