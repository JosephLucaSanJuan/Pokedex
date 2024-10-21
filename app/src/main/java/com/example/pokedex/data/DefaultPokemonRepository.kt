package com.example.pokedex.data

import com.example.pokedex.data.remote.PokemonRemoteDataSource
import javax.inject.Inject

class DefaultPokemonRepository
    @Inject constructor(
        private val remoteDataSource: PokemonRemoteDataSource
    ):PokemonRepository {
    override suspend fun readAll(): List<Pokemon> {
        val pokemons = remoteDataSource.readAll()
        return pokemons
    }

    override suspend fun readOne(id: Int): String {
        TODO("Not yet implemented")
    }
}