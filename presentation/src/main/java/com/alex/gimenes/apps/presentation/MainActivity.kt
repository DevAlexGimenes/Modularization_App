package com.alex.gimenes.apps.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.alex.gimenes.apps.presentation.navigation.Navigation
import com.alex.gimenes.apps.presentation.ui.theme.ModularizationAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModularizationAppTheme {
                Navigation(this)
            }
        }
    }
}