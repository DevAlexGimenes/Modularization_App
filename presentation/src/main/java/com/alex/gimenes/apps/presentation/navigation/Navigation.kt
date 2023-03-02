package com.alex.gimenes.apps.presentation.navigation

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alex.gimenes.apps.presentation.features.character_details.CharacterDetailViewModel
import com.alex.gimenes.apps.presentation.features.character_details.CharacterDetails
import com.alex.gimenes.apps.presentation.features.home.Home
import com.alex.gimenes.apps.presentation.features.splash_screen.AnimatedSplashScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Navigation(context: Context) {
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
                AnimatedSplashScreen(
                    onSplashFinish = {
                        navController.popBackStack()
                        navController.navigate(Route.HOME)
                    }
                )
            }
            composable(route = Route.HOME) {
                Home(
                    navigateToCharacterDetails = {
                        navController.navigate(Route.CHARACTER_DETAILS)
                    }
                )
            }
            composable(route = Route.CHARACTER_DETAILS) {
                CharacterDetails()
            }
        }
    }
}