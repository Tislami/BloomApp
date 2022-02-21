package com.example.bloomapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun BloomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String?= null,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,

    ){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.body1,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        leadingIcon = leadingIcon,
        singleLine = true,
        maxLines = 1,
        label = { if(label!=null)InsideText(text = label) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            cursorColor = Color.Gray))
}

@Composable
fun InsideText(
    text: String
){
    Text(
        text = text,
        style = MaterialTheme.typography.body1,
        color = MaterialTheme.colors.onBackground)
}