package com.alex.gimenes.apps.presentation_character_details.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BoxInformation(
    informationName: String? = "None",
    information: String? = "None",
    informationTxtColor: Color = MaterialTheme.colors.primaryVariant
) {
    Box(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp)
            .fillMaxWidth()
            .shadow(8.dp)
            .clip(RoundedCornerShape(7.dp))
            .background(MaterialTheme.colors.secondary),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(modifier = Modifier.padding(15.dp)) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(7.dp))
                    .background(MaterialTheme.colors.secondaryVariant)
            ) {
                informationName?.let {
                    Text(
                        text = it,
                        color = MaterialTheme.colors.primaryVariant,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }
            }
            information?.let {
                Text(
                    text = it,
                    color = informationTxtColor,
                    modifier = Modifier.padding(5.dp),
                )
            }
        }
    }
}