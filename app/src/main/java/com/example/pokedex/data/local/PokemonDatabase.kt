package com.example.pokedex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokedex.data.Pokemon

@Database(entities = [Pokemon::class], version = 1)
abstract class PokemonDatabase():RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}