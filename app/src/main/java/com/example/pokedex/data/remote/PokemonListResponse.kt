package com.example.pokedex.data.remote

data class PokemonListResponse(
    val count:Int,
    val next:String,
    val results:List<PokemonListItemResponse>
)

data class PokemonListItemResponse(
    val name:String,
    val url:String
)
