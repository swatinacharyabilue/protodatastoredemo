package com.ganbaru.myprotodemoapplication

sealed class NavigationItem (var route: String, var icon: Int, var title: String) {
    data object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    data object Movies : NavigationItem("movies", R.drawable.ic_video, "Videos")
    data object Profile : NavigationItem("profile", R.drawable.ic_profile, "Profile")
}