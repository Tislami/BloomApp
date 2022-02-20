package com.example.bloomapp.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier) {

    Column() {
        Text(text = "Login")
    }

}