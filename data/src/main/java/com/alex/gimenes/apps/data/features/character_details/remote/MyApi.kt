package com.alex.gimenes.apps.data.features.character_details.remote

import retrofit2.http.GET
import com.alex.gimenes.apps.domain.features.character_details.model.Character

interface MyApi {

    @GET("character/10")
    suspend fun getCharacter() : Character
}