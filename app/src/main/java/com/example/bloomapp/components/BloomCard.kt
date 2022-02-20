package com.example.bloomapp.components

import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BloomCard(
    modifier: Modifier = Modifier,
    content: @Composable ()-> Unit
    ){

    Card(
        modifier = modifier,
        elevation = 1.dp,
        shape = MaterialTheme.shapes.small,
        content=content,
    )

}