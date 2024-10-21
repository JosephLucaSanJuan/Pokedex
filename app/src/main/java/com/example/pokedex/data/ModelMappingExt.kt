package com.example.pokedex.data

import com.example.pokedex.data.remote.PokemonListItemResponse
import com.example.pokedex.data.remote.PokemonListResponse

fun PokemonListResponse.toExternal() = results.map(PokemonListItemResponse::toExternal)

fun PokemonListItemResponse.toExternal() = Pokemon(name = this.name)