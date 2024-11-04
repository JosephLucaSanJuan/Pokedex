package com.example.pokedex.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon")
    suspend fun readAll():List<Pokemon>

    @Query("SELECT * FROM pokemon WHERE id LIKE :id")
    suspend fun readOne(id:Int):Pokemon

    @Query("SELECT * FROM pokemon")
    fun observeAll(): Flow<List<Pokemon>>
}