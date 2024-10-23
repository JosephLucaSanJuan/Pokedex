package com.example.pokedex.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.Pokemon
import com.example.pokedex.data.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: PokemonRepository
):ViewModel() {
    suspend fun read():List<Pokemon> {
        return repository.readAll()
    }

    private val _uiState = MutableStateFlow<PokedexUiState>(PokedexUiState.Loading)
    val uiState: StateFlow<PokedexUiState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.observeAll().collect { pokemons ->
                _uiState.value = PokedexUiState.Success(pokemons)
            }
        }
    }
}

sealed class PokedexUiState {
    data object Loading: PokedexUiState()
    class Error(message:String):PokedexUiState()
    class Success(val pokemon: List<Pokemon>): PokedexUiState()
}

data class PokemonUiState(
    val id:Int = 0,
    val nombre:String = ""
)