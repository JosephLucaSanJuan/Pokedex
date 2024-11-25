package com.example.pokedex.data.remote

data class PokemonListResponse(
    val count:Int,
    val next:String,
    val results:List<PokemonListItemResponse>
)

data class PokemonListItemResponse(
    val id:Int,
    val name:String,
    val height: Int,
    val weight: Int
)
