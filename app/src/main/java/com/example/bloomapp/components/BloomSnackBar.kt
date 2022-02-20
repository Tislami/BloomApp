package com.example.bloomapp.components

import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarData
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BloomSnackBar(
    modifier: Modifier = Modifier,
    snackbarData: SnackbarData
){
    Snackbar(
        snackbarData = snackbarData,
        modifier = modifier,
        elevation = 2.dp,
        shape = MaterialTheme.shapes.small
    )

}