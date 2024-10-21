package com.example.pokedex.data.remote

import com.example.pokedex.data.Pokemon
import com.example.pokedex.data.toExternal
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

    override suspend fun readOne(): String {
        TODO("Not yet implemented")
    }
}