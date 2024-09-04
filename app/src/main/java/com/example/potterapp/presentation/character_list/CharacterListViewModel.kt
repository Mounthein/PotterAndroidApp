package com.example.potterapp.presentation.character_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potterapp.common.Resource
import com.example.potterapp.data.repository.CharacterRepositoryImpl
import com.example.potterapp.domain.model.CharacterSimple
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
class CharacterListViewModel @Inject constructor(
    private val api : CharacterRepositoryImpl,
) : ViewModel() {
    private val _state = MutableStateFlow(CharacterListState())
    val state: StateFlow<CharacterListState> = _state.asStateFlow()

    init {
        getListToPresent()
    }

    private fun getListFromApi(): Flow<Resource<List<CharacterSimple>>> = flow {
        try {
            emit(Resource.Loading<List<CharacterSimple>>())
            val characters = api.getSimpleCharacters()
            emit(Resource.Success<List<CharacterSimple>>(characters))
        } catch (e: HttpException) {
            emit(Resource.Error<List<CharacterSimple>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error<List<CharacterSimple>>("Couldn't reach server. Check your internet connection."))
        }
    }

    private fun getListToPresent(){
        getListFromApi().onEach {
            when (it){
                is Resource.Success -> {
                    _state.value = CharacterListState(characters = it.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CharacterListState(
                        error = it.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CharacterListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}