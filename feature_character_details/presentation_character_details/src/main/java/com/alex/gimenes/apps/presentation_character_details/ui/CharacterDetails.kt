package com.alex.gimenes.apps.presentation_character_details.ui

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alex.gimenes.apps.domain_character_details.utils.State.*
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.alex.gimenes.apps.domain_character_details.character_details.model.Character
import com.alex.gimenes.apps.presentation_character_details.ui.utils.BoxInformation

@OptIn(ExperimentalGlideComposeApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CharacterDetails(
    viewModel: CharacterDetailViewModel = hiltViewModel(),
    characterId: Int = 1
) {
    viewModel.getCharacterDetail(characterId)

    val isLoading = remember {
        mutableStateOf(true)
    }
    val isCharacter = remember {
        mutableStateOf(Character())
    }
    val status = mapOf(
        "Alive" to Color.Green,
        "Dead" to Color.Red,
        "unknown" to Color.Yellow
    )

    LaunchedEffect(key1 = true) {
        viewModel.validationEvent.collect { event ->
            if (event is Success) {
                isLoading.value = false
                isCharacter.value = event.data
            } else {
                isLoading.value = false
            }
        }
    }
    LoadingItem(
        isLoading = isLoading.value,
        contentAfterLoading = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.secondary),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.secondary)
                        .padding(15.dp),
                    contentAlignment = Alignment.Center
                ) {
                    GlideImage(
                        model = isCharacter.value.image,
                        contentDescription = "Character image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(200.dp)
                            .height(200.dp)
                            .clip(CircleShape)
                            .border(
                                width = 3.dp,
                                color = MaterialTheme.colors.primary,
                                shape = CircleShape
                            )
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                        .fillMaxSize()
                        .background(MaterialTheme.colors.primary),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    BoxInformation(
                        informationName = "Name",
                        information = isCharacter.value.name
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    BoxInformation(
                        informationName = "Specie",
                        information = isCharacter.value.species
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    BoxInformation(
                        informationName = "Status",
                        information = isCharacter.value.status,
                        informationTxtColor = status[isCharacter.value.status] ?: Color.Black
                    )
                }
            }
        }
    )
}

@Composable
fun LoadingItem(
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    if (isLoading) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.primary),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colors.primaryVariant,
                modifier = Modifier.size(60.dp)
            )
        }
    } else {
        AnimatedVisibility(visible = true, enter = fadeIn(), exit = fadeOut()) {
            contentAfterLoading()
        }
    }
}