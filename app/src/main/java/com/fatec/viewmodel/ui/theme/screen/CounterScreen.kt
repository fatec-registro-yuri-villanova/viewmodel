package com.fatec.viewmodel.ui.theme.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

// Passo 3: Obtenha a instância do ViewModel no Composable
@Composable
fun CounterScreen(
    viewModel: CounterViewModel = viewModel()
) {
    // Coleta o estado da tela
    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        // Exibe o valor atual do contador
        Text(
            text = "Contagem: ${uiState.count}",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de entrada para o valor de incremento/decremento
        TextField(
            value = uiState.incrementValueInput,
            onValueChange = {
                viewModel.onIncrementValueChange(it)
            },
            label = {
                Text("Valor a ser incrementado/decrementado")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Botão para decrementar
            Button(onClick = { viewModel.decrement() }) {
                Text(text = "Decrementar")
            }

            // Botão para incrementar
            Button(onClick = { viewModel.increment() }) {
                Text(text = "Incrementar")
            }
        }
    }
}