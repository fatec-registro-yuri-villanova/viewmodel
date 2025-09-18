package com.fatec.viewmodel.ui.theme.screen



/**
 * Representa o estado da tela do contador.
 */
data class CounterUiState(
    val count: Int = 0,
    val incrementValueInput: String = ""
)