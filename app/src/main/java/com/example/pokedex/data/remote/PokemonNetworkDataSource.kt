package com.example.pokedex.data.remote

import com.example.pokedex.data.Pokemon
import com.example.pokedex.data.toExternal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonNetworkDataSource
    @Inject constructor(
        private val pokeApi: PokeApi
    ):PokemonRemoteDataSource {
    override suspend fun readAll(): List<Pokemon> {
        val pokemonResult = pokeApi.read()
        return if (pokemonResult.isSuccessful) {
            pokemonResult.body()!!.toExternal()
        }
        else {
            listOf<Pokemon>()
        }
    }

    override suspend fun readOne(id:Int): Pokemon {
        TODO("Not yet implemented")
    }

    override fun observeAll(): Flow<List<Pokemon>> {
        TODO("Not yet implemented")
    }
}