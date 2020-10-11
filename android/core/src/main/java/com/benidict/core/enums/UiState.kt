package com.benidict.core.enums

/**
 * generic sealed class, this class is for controlling the state in our view after emitting data in view model.
 **/
sealed class UiState<T>{
    object Loading: UiState<Nothing>()
    class Complete<T>(val data: T): UiState<T>()
    class Error<T>(val error: Throwable): UiState<T>()
}