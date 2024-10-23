package com.example.pokedex.data

import com.example.pokedex.data.remote.PokemonRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultPokemonRepository
    @Inject constructor(
        private val remoteDataSource: PokemonRemoteDataSource
    ):PokemonRepository {
    override suspend fun readAll(): List<Pokemon> {
        val pokemons = remoteDataSource.readAll()
        return pokemons
    }

    override suspend fun readOne(id: Int): Pokemon {
        return remoteDataSource.readOne(id)
    }

    override fun observeAll(): Flow<List<Pokemon>> {
        return remoteDataSource.observeAll()
    }
}