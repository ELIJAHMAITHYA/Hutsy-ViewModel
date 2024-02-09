package com.example.hutsyviewmodelpresentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class Vm(
    var number: Float = 0.0F,
    var number2: Float = 0.0F,
)

class ViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(Vm())
    val uiState: StateFlow<Vm> = _uiState.asStateFlow()

    fun add3() {
        _uiState.update { currentState ->
            currentState.copy(number = currentState.number + 3)
        }
    }

    fun minus3() {
        _uiState.update { currentState ->
            currentState.copy(number = currentState.number - 3)
        }
    }

    fun mutliply3() {
        _uiState.update { currentState ->
            currentState.copy(number = currentState.number * 3)
        }
    }

    fun reset() {
        _uiState.update { currentState ->
            currentState.copy(number = 0.0F)
        }
    }
}
