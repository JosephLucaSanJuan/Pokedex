package com.example.pokedex.data.remote

import com.example.pokedex.data.Pokemon

interface PokemonRemoteDataSource {
    suspend fun readAll():List<Pokemon>
    suspend fun readOne():String
}