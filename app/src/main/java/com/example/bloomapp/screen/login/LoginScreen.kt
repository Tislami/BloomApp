package com.example.bloomapp.screen.login
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bloomapp.R
import com.example.bloomapp.components.BloomButton
import com.example.bloomapp.components.BloomOutlinedTextField

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel = viewModel()) {

    val emailAddress by loginViewModel.emailAddress.observeAsState("")
    val password by loginViewModel.password.observeAsState("")

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = stringResource(id = R.string.login_title),
                modifier = modifier.paddingFromBaseline(top = 184.dp),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.h1)

            Spacer(modifier = Modifier.height(16.dp))


            BloomOutlinedTextField(
                value = emailAddress,
                onValueChange = loginViewModel::onEmailAddressChange,
                label = stringResource(id = R.string.email_address),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                )
            
            Spacer(modifier = Modifier.height(8.dp))

            BloomOutlinedTextField(
                value = password,
                onValueChange = loginViewModel::onPasswordChange,
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
                onClick = {navController.navigate("home")},
            )
        }
    }
}