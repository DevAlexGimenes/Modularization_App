package com.alex.gimenes.apps.domain_character_details.utils

sealed class State<out T> {
    data class Success<T>(val data: T) : State<T>()
    data class Error(val error: Throwable) : State<Nothing>()
}