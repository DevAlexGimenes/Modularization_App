package com.alex.gimenes.apps.data_character_details.repository

import com.alex.gimenes.apps.data_character_details.remote.MyApi
import com.alex.gimenes.apps.domain_character_details.character_details.model.Character
import com.alex.gimenes.apps.domain_character_details.character_details.repository.CharacterDetailsRepository
import com.alex.gimenes.apps.domain_character_details.utils.State

class CharacterDetailsRepositoryImpl(
    private val myApi: MyApi
) : CharacterDetailsRepository {

    override suspend fun getCharacterDetails(id: Int) : State<Character> {
        return try {
            State.Success(myApi.getCharacter(id.toString()))
        } catch (e: Throwable) {
            State.Error(e)
        }
    }
}