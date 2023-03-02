package com.alex.gimenes.apps.presentation.features.character_details

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alex.gimenes.apps.domain.utils.State.*
import com.alex.gimenes.apps.presentation.R
import com.alex.gimenes.apps.presentation.ui.theme.Yellow
import com.alex.gimenes.apps.presentation.ui.theme.Yellow2
import com.alex.gimenes.apps.presentation.ui.theme.Yellow3
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CharacterDetails(
    viewModel: CharacterDetailViewModel = hiltViewModel()
) {
    viewModel.getCharacterDetail(2)

    val isLoading = remember {
        mutableStateOf(true)
    }

    val isCharacter = remember {
        mutableStateOf(com.alex.gimenes.apps.domain.features.character_details.model.Character())
    }

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
    ShimmerItem(
        isLoading = isLoading.value,
        contentAfterLoading = {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Yellow3)
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
                            .border(width = 3.dp, color = Color.White, shape = CircleShape)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .background(Yellow),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    CharacterInformation(
                        informationName = "Name",
                        information = isCharacter.value.name!!
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    CharacterInformation(
                        informationName = "Specie",
                        information = isCharacter.value.species!!
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    CharacterInformation(
                        informationName = "Status",
                        information = isCharacter.value.status!!,
                        informationTxtColor = when(isCharacter.value.status!!) {
                            "Alive" -> Color.Green
                            "Dead" -> Color.Red
                            "unknown" -> Color.Gray
                            else -> Color.Black
                        }
                    )
                }
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    )
}

@Composable
fun ShimmerItem(
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    if (isLoading) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(Modifier.weight(1f)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(20.dp)
                        .shimmerEffect()
                )
            }
        }
    } else {
        contentAfterLoading()
    }
}

fun Modifier.shimmerEffect(): Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition()
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.height.toFloat(),
        animationSpec = infiniteRepeatable(animation = tween(1000))
    )

    background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFB8B5B5),
                Color(0xFF8F8B8B),
                Color(0xFFB8B5B5),
            ),
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        )
    ).onGloballyPositioned {
            size = it.size
        }
}

@Composable
fun CharacterInformation(
    informationName: String,
    information: String,
    informationTxtColor: Color = Color.Black
) {
    Box(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp)
            .fillMaxWidth()
            .shadow(8.dp)
            .clip(RoundedCornerShape(7.dp))
            .background(Yellow2),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(modifier = Modifier.padding(15.dp)) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(7.dp))
                    .background(Yellow3)
            ) {
                Text(
                    text = informationName,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
            Text(
                text = information,
                color = informationTxtColor,
                modifier = Modifier.padding(5.dp),
            )
        }
    }
}