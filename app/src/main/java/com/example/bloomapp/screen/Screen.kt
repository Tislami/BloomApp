package com.example.bloomapp.screen

import androidx.annotation.StringRes
import com.example.bloomapp.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Welcome : Screen("welcome", R.string.welcome_screen)
    object Login : Screen("login", R.string.login_screen)
    object Home : Screen("home", R.string.home_screen)
    object Favorites : Screen("favorites", R.string.favorites_screen)
    object Profile : Screen("profile", R.string.profile_screen)
    object Cart : Screen("cart", R.string.cart_screen)
}