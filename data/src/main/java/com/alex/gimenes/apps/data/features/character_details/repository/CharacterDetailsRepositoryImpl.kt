package com.alex.gimenes.apps.data.features.character_details.repository

import com.alex.gimenes.apps.data.features.character_details.remote.MyApi
import com.alex.gimenes.apps.domain.features.character_details.model.Character
import com.alex.gimenes.apps.domain.features.character_details.repository.CharacterDetailsRepository
import com.alex.gimenes.apps.domain.utils.State

class CharacterDetailsRepositoryImpl(
    private val myApi: MyApi
) : CharacterDetailsRepository {

    override suspend fun getCharacterDetails(id: Int) : State<Character> {
        return try {
            State.Success(myApi.getCharacter())
        } catch (e: Throwable) {
            State.Error(e)
        }
    }
}