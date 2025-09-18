package com.fatec.viewmodels.ui.screens

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fatec.viewmodel.ui.theme.ViewmodelTheme

@Composable
fun CounterScreen(
    modifier: Modifier = Modifier,
    viewModel: CounterViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Text(
            "Contagem: ${uiState.count}",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = uiState.incrementValueInput,
            onValueChange = {
                viewModel.onIncrementValueChange(it)
            },
            label = {
                Text("Valor a ser incrementado")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Botão para decrementar
            Button(onClick = {
                viewModel.increment()
            }) {
                Text(text = "Decrementar")
            }

            // Botão para incrementar
            Button(onClick = { viewModel.increment() }) {
                Text(text = "Incrementar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CounterScreenPreview() {
    ViewmodelTheme {
        CounterScreen()
    }
}