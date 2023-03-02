package com.alex.gimenes.apps.domain.features.character_details.repository

import com.alex.gimenes.apps.domain.features.character_details.model.Character
import com.alex.gimenes.apps.domain.utils.State

interface CharacterDetailsRepository {
    suspend fun getCharacterDetails(id: Int) : State<Character>
}