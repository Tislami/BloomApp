package com.example.bloomapp.screen.login
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bloomapp.R
import com.example.bloomapp.components.BloomButton

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier) {

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = stringResource(id = R.string.login_title),
                modifier = modifier.paddingFromBaseline(top = 184.dp),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.h1)

            Spacer(modifier = Modifier.height(16.dp))

            LoginOutlinedTextField(
                value = "",
                onValueChange = {},
                label = stringResource(id = R.string.email_address),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                )
            
            Spacer(modifier = Modifier.height(8.dp))

            LoginOutlinedTextField(
                value = "",
                onValueChange = {},
                label = stringResource(id = R.string.password_desc),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = VisualTransformation.None
            )
            
            Text(
                text = stringResource(id = R.string.privacy_policy),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center,
                modifier = modifier.padding(top = 24.dp, bottom = 16.dp)
            )

            BloomButton(
                text = stringResource(id = R.string.welcome_log_in),
                onClick = {navController.navigate("")},
            )
        }
    }
}


@Composable
fun LoginOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String?= null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    placeholder: String="",

){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.body1,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true,
        maxLines = 1,
        label = { if(label!=null)InsideText(text = label) },
        placeholder = { InsideText(text = placeholder)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray))
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