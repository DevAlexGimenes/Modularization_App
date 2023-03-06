package com.alex.gimenes.apps.presentation_character_details.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.gimenes.apps.domain_character_details.character_details.model.Character
import com.alex.gimenes.apps.domain_character_details.character_details.repository.CharacterDetailsRepository
import com.alex.gimenes.apps.domain_character_details.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val characterDetailsRepository: CharacterDetailsRepository
) : ViewModel() {

    val validationEvent = MutableSharedFlow<State<Character>>()

    fun getCharacterDetail(id: Int) {
        viewModelScope.launch {
            delay(2000)
            validationEvent.emit(characterDetailsRepository.getCharacterDetails(id))
        }
    }
}