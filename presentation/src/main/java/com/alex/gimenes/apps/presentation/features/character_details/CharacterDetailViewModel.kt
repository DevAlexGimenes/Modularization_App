package com.alex.gimenes.apps.presentation.features.character_details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.gimenes.apps.domain.features.character_details.repository.CharacterDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.alex.gimenes.apps.domain.features.character_details.model.Character
import com.alex.gimenes.apps.domain.utils.State
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

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