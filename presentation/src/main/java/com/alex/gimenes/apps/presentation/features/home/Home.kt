package com.alex.gimenes.apps.presentation.features.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Home(navigateToCharacterDetails: () -> Unit){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.secondary
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "Home", style = MaterialTheme.typography.h2 )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                onClick = { navigateToCharacterDetails() }
            ) {
                Text(text = "Sort Character", modifier = Modifier.padding(10.dp))
            }
        }
    }
}