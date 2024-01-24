package com.ganbaru.myprotodemoapplication.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.ganbaru.myprotodemoapplication.ui.userprofile.ProfileViewModel


@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Welcome, this is your home.", color = Color.Black, fontSize = 12.sp)
    }
}

@Composable
fun VideosScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Your videos will be here.", color = Color.Black, fontSize = 12.sp)
    }
}

@Composable
fun ProfileScreen(profileViewModel: ProfileViewModel) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        val userProfile = profileViewModel.userProfile?.observeAsState()?.value
        val profileText = userProfile?.id.toString() +  "\n"+ userProfile?.firstName + "\n" +
                userProfile?.lastName + "\n"  + userProfile?.email + "\n"  + userProfile?.phone + "\n"
        Text(text = profileText, color = Color.Black, fontSize = 12.sp)
    }
}