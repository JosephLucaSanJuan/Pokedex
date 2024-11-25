package com.example.pokedex.data

import com.example.pokedex.data.local.toLocal
import com.example.pokedex.data.remote.PokemonListItemResponse
import com.example.pokedex.data.remote.PokemonListResponse

fun PokemonListResponse.toExternal() = results.map(PokemonListItemResponse::toExternal)

fun PokemonListItemResponse.toExternal(): Pokemon {
    return Pokemon(
        id = this.id,
        name = this.name,
        height = this.height,
        weight = this.weight
    )
}