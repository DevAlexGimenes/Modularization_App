package com.alex.gimenes.apps.data.features.character_details.remote

import retrofit2.http.GET
import com.alex.gimenes.apps.domain.features.character_details.model.Character
import retrofit2.http.Path

interface MyApi {

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: String) : Character
}