package com.example.potterapp.presentation.character_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun CharacterDetailScreen(
    navController: NavController,
    viewModel: CharacterViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            state.isLoading -> {
                CircularProgressIndicator()
            }

            state.error.isNotBlank() -> {
                Text(text = state.error)
            }

            else -> {
                state.character?.let { chara ->
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(20.dp)
                    ) {
                        item {
                            Text(text = chara.name)
                            Text(text = chara.gender)
                            Text(text = chara.actor)
                            Text(text = chara.house)
                        }
                    }
                }
            }
        }
    }
}