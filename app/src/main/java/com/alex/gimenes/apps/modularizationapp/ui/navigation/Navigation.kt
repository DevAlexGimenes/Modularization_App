package com.alex.gimenes.apps.modularizationapp.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alex.gimenes.apps.feature_home.Home
import com.alex.gimenes.apps.feature_splash_screen.AnimatedSplashScreen
import com.alex.gimenes.apps.presentation_character_details.ui.CharacterDetails
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        NavHost(
            navController = navController,
            startDestination = Route.SPLASH_SCREEN
        ) {
            composable(route = Route.SPLASH_SCREEN) {
                AnimatedSplashScreen {
                    navController.navigate(Route.HOME)
                }
            }
            composable(route = Route.HOME) {
                Home {
                    navController.navigate(Route.CHARACTER_DETAILS)
                }
            }
            composable(route = Route.CHARACTER_DETAILS) {
                CharacterDetails()
            }
        }
    }
}