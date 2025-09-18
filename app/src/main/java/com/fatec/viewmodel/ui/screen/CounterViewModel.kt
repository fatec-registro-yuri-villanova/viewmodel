package com.fatec.viewmodels.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CounterUiState())
    val uiState: StateFlow<CounterUiState> = _uiState.asStateFlow()

    fun onIncrementValueChange(newValue: String) {
        _uiState.value = _uiState.value.copy(
            incrementValueInput = newValue
        )
    }

    fun increment(){
        val incrementValue = _uiState.value.incrementValueInput.toIntOrNull() ?: 1
        _uiState.value = _uiState.value.copy(
            count = _uiState.value.count + incrementValue
        )
    }
}