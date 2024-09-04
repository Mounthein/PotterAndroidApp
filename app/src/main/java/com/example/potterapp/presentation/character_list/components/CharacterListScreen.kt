package com.example.potterapp.presentation.character_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.potterapp.presentation.character_list.CharacterListViewModel
import androidx.hilt.navigation.compose.hiltViewModel



@Composable
fun CharacterListScreen(
    viewModel: CharacterListViewModel = hiltViewModel()
){
    val state = viewModel.state.collectAsState().value
    Box(modifier = Modifier.fillMaxSize()){
        when {
            state.isLoading -> {
                CircularProgressIndicator()
            }
            state.error.isNotBlank() -> {
                Text(text = state.error)
            }
            else -> {
                LazyColumn {
                    items(state.characters) { character ->
                        CharacterListItem(character = character) {

                        }
                    }
                }
            }
        }
    }
}
