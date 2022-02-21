package com.example.bloomapp.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bloomapp.MockData
import com.example.bloomapp.R
import com.example.bloomapp.components.BloomOutlinedTextField
import com.example.bloomapp.components.PlantCard
import com.example.bloomapp.components.ThemeCard

import kotlinx.coroutines.NonDisposableHandle.parent

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = viewModel()
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp)
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
        )
        {
            Spacer(Modifier.height(40.dp))

            BloomOutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.padding(end = 16.dp),
                label = stringResource(id = R.string.search),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(id = R.string.search),
                        modifier = Modifier.size(18.dp)
                    )
                })

            HomeTitleText(
                text = stringResource(id = R.string.home_title1),
                modifier = modifier.paddingFromBaseline(32.dp)
            )
            
            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(MockData.themes) {
                    ThemeCard(themes = it)
                }
            }

            HomeTitleText(
                text = stringResource(id = R.string.home_title2),
                modifier = modifier.paddingFromBaseline(40.dp)
            )
            
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(bottom = 64.dp)
            ) {
                items(MockData.plants) {
                    PlantCard(plants = it)
                }
            }
        }
    }
}

@Composable
fun HomeTitleText(
    text: String,
    modifier: Modifier = Modifier,
){
    Text(text = text,
        style = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.onBackground,
        modifier = modifier.fillMaxWidth()
    )
}