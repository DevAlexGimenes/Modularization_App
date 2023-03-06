package com.alex.gimenes.apps.modularizationapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.alex.gimenes.apps.modularizationapp.ui.navigation.Navigation
import com.alex.gimenes.apps.modularizationapp.ui.ui.theme.ModularizationAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModularizationAppTheme {
                Navigation()
            }
        }
    }
}