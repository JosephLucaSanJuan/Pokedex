package com.example.pokedex.data.local

import androidx.room.PrimaryKey
import com.example.pokedex.data.Pokemon

fun Pokemon.toLocal():PokemonEntity{
    return PokemonEntity(
        id = this.id,
        name = this.name,
        /*height = this.height,
        weight = this.weight*/
    )
}

fun List<Pokemon>.toLocal():List<PokemonEntity>{
    return this.map { p -> p.toLocal() }
}

fun PokemonEntity.toExternal() = Pokemon(
        id = this.id,
        name = this.name,
        /*height = this.height,
        weight = this.weight*/
    )

fun List<PokemonEntity>.toExternal() = map(PokemonEntity::toExternal)