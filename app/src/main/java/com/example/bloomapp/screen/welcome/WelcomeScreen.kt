package com.example.bloomapp.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bloomapp.R

@Composable
fun WelcomeScreen(
    navController: NavController,
    modifier: Modifier= Modifier) {

    val welcomeBg = if (isSystemInDarkTheme()) {
        R.drawable.dark_welcome_bg;
    } else {
        R.drawable.light_welcome_bg;
    }
    val welcomeIllos = if (isSystemInDarkTheme()) {
        R.drawable.dark_welcome_illos;
    } else {
        R.drawable.light_welcome_illos;
    }
    val logo = if (isSystemInDarkTheme()) {
        R.drawable.dark_logo;
    } else {
        R.drawable.light_logo;
    }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.primary
    ) {

        Image(
            painter = painterResource(id = welcomeBg),
            contentDescription = null,
            modifier = modifier.fillMaxHeight(),
        )

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = Modifier.height(72.dp))

            Image(
                painter = painterResource(id = welcomeIllos),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .offset(x = 88.dp)
            )

            Spacer(modifier = Modifier.height(48.dp))

            Image(
                painter = painterResource(id = logo),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
            )

            Text(
                text = stringResource(id = R.string.welcome_subtitle),
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onBackground,
                modifier = modifier.paddingFromBaseline(bottom = 40.dp, top = 32.dp)
            )

            Button(
                onClick = {
                    navController.navigate("login") },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(48.dp),
                shape = RoundedCornerShape(percent = 50),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)
            ) {

                Text(
                    text = stringResource(id = R.string.welcome_create_account),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.onSecondary
                )
            }

            var state =


            TextButton(
                onClick = { navController.navigate("login")  },
                modifier = modifier.padding(top = 16.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.welcome_log_in),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.secondary
                )
            }
        }
    }
}

