package com.example.pokedex.ui

import androidx.lifecycle.ViewModel
import com.example.pokedex.data.Pokemon
import com.example.pokedex.data.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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
}

sealed class PokedexUiState {
    data object Loading: PokedexUiState()
    class Error(message:String):PokedexUiState()
    class Success(val pokemon: List<Pokemon>)
}