package com.example.bloomapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bloomapp.screen.Screen
import com.example.bloomapp.screen.cart.CartScreen
import com.example.bloomapp.screen.favorites.FavoritesScreen
import com.example.bloomapp.screen.home.HomeScreen
import com.example.bloomapp.screen.login.LoginScreen
import com.example.bloomapp.screen.profile.ProfileScreen
import com.example.bloomapp.screen.welcome.WelcomeScreen
import com.example.bloomapp.ui.theme.BloomAppTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.insets.statusBarsPadding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            BloomAppTheme {
                ProvideWindowInsets {
                    Main()
                }
            }
        }
    }
}


@Composable
fun Main(){
    val navController = rememberNavController()

    val bottomNavigationItems = listOf(
        Screen.Home,
        Screen.Favorites,
        Screen.Profile,
        Screen.Cart,
    )

    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomNavigationItems.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                Icons.Filled.Favorite,
                                contentDescription = null
                            )
                        },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    )
    {
        NavHostManager(navController = navController)
    }
}

@Composable
fun NavHostManager(navController: NavHostController){
    NavHost(navController = navController, startDestination = "home") {
        composable("welcome") { WelcomeScreen(navController = navController) }
        composable("login") { LoginScreen(navController = navController) }
        composable("home") { HomeScreen(navController = navController) }
        composable("favorites") { FavoritesScreen(navController = navController) }
        composable("profile") { ProfileScreen(navController = navController) }
        composable("cart") { CartScreen(navController = navController) }
    }
}

