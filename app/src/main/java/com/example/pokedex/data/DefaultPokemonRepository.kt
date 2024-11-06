package com.example.pokedex.data

import com.example.pokedex.data.local.PokemonLocalDataSource
import com.example.pokedex.data.remote.PokemonRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class DefaultPokemonRepository
    @Inject constructor(
        private val localDataSource: PokemonLocalDataSource,
        private val remoteDataSource: PokemonRemoteDataSource
    ):PokemonRepository {
    override suspend fun readAll(): List<Pokemon> {
        val pokemons = remoteDataSource.readAll()
        return pokemons
    }

    override suspend fun readOne(id: Int): Pokemon {
        return remoteDataSource.readOne(id)
    }

    private fun refreshLocal(){
        runBlocking {
            val pokemonRemote = remoteDataSource.readAll()
            localDataSource.insert(pokemonRemote)
        }
    }

    override fun observeAll(): Flow<List<Pokemon>> {
        refreshLocal()
        return localDataSource.observeAll()
    }
}