package com.example.bloomapp.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BloomBottomNavigation(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.()-> Unit
){

    BottomNavigation(
        modifier = modifier,
        elevation = 16.dp,
        content=content,
        backgroundColor = MaterialTheme.colors.primary
    )

}