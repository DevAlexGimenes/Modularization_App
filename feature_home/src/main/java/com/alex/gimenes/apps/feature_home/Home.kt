package com.alex.gimenes.apps.feature_home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
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
            verticalArrangement = Arrangement.Top
        ) {
            Column(
                modifier = Modifier.fillMaxSize().weight(2f).background(MaterialTheme.colors.background),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "Home",
                    color = MaterialTheme.colors.primaryVariant,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .padding(top = 20.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_rick_and_morty),
                    contentDescription = "home asset",
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.surface)
                    .weight(1.9f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp, top = 30.dp),
                    onClick = { navigateToCharacterDetails() },
                    colors =ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondaryVariant
                    )
                ) {
                    Text(
                        text = "CHARACTER INFORMATION",
                        color = MaterialTheme.colors.primaryVariant,
                        modifier = Modifier
                            .padding(10.dp)
                            .clip(RoundedCornerShape(3.dp))
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp)
                        .background(MaterialTheme.colors.secondaryVariant),
                    onClick = { },
                    colors =ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondaryVariant
                    )
                ) {
                    Text(
                        text = "OTHER FEATURE",
                        color = MaterialTheme.colors.primaryVariant,
                        modifier = Modifier
                            .padding(10.dp)
                            .clip(RoundedCornerShape(3.dp))
                    )
                }
            }
        }
    }
}