package com.alex.gimenes.apps.data_character_details.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: String) : com.alex.gimenes.apps.domain_character_details.character_details.model.Character
}