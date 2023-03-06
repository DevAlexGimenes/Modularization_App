package com.alex.gimenes.apps.domain_character_details.character_details.repository

import com.alex.gimenes.apps.domain_character_details.character_details.model.Character
import com.alex.gimenes.apps.domain_character_details.utils.State
interface CharacterDetailsRepository {
    suspend fun getCharacterDetails(id: Int) : State<Character>
}