package com.example.bloomapp.components
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString

@Composable
fun BloomText(
    text: String,
    modifier: Modifier = Modifier,
){
    Text(
        text = text,
        style = MaterialTheme.typography.h2,
        color = MaterialTheme.colors.onBackground,
        modifier = modifier)
}