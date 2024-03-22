package com.example.template.feature.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MainRoute(
    viewModel: MainViewModel = hiltViewModel()
){
    val state : MainState by viewModel.state.collectAsStateWithLifecycle()

    MainScreen(
        state = state,
        onEvent = viewModel::handleEvents
    )
}

@Composable
private fun MainScreen(
    state: MainState,
    onEvent: (MainEvent) -> Unit
){
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        MainCount(count = state.count, onClickAdd = { onEvent(MainEvent.OnClickAdd) })

        MainName(name = state.name, onNameChange = { onEvent(MainEvent.OnChangeName(it)) })
    }
}

@Composable
private fun MainCount(
    count: Int,
    onClickAdd: () -> Unit
){
    Text(text = "Count: $count")

    Button(onClick = onClickAdd) {
        Text(text = "Add")
    }
}

@Composable
private fun MainName(
    name: String,
    onNameChange: (String) -> Unit
) {
    OutlinedTextField(value = name, onValueChange = onNameChange)
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview(){
    MainScreen(
        state = MainState(),
        onEvent = {}
    )
}