package com.example.potterapp.presentation.character_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potterapp.common.Resource
import com.example.potterapp.data.remote.dto.CharacterDetailDTO
import com.example.potterapp.data.repository.CharacterRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepositoryImpl,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(CharacterState())
    val state: StateFlow<CharacterState> = _state.asStateFlow()

    private val characterId: String = ""
    init {

    }

    private fun getCharacterFromApi(): Flow<Resource<CharacterDetailDTO>> = flow {
        try {
            emit(Resource.Loading<CharacterDetailDTO>())
            val character = repository.getCharacter(characterId)
            emit(Resource.Success<CharacterDetailDTO>(character))
        } catch (e: HttpException){
            emit(Resource.Error<CharacterDetailDTO>("e.localizedMessage ?: An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error<CharacterDetailDTO>(message = "Couldn't reach server. Check your internet connection"))
        }
    }

    private fun getCharacter(){
        getCharacterFromApi().onEach {
            when (it){
                is Resource.Success -> {
                    _state.value = CharacterState(character = it.data)
                }
                is Resource.Error -> {
                    _state.value = CharacterState(
                        error = it.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CharacterState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}