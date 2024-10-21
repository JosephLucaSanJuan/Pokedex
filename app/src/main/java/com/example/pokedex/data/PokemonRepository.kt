package com.example.pokedex.data

interface PokemonRepository {
    suspend fun readAll():List<Pokemon>
    suspend fun readOne(id:Int):String
}