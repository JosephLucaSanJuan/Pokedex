package com.example.pokedex.data.local

import com.example.pokedex.data.Pokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonLocalDatabase/* @Inject constructor(private val dao:PokemonDao)*/:PokemonLocalDataSource {
    override suspend fun insert(pokemons: List<Pokemon>) {
        TODO("Not yet implemented")
    }

    override suspend fun readAll(): Flow<List<Pokemon>> {
        TODO("Not yet implemented")
    }

    override fun observeAll(): Flow<List<Pokemon>> {
        TODO("Not yet implemented")
        /** return dao.observeAll().map { localPokemons ->
         *      localPokemons.toExternal()
         *  }**/
    }
}