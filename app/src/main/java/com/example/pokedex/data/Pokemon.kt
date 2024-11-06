package com.example.pokedex.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Pokemon(
    val id:Int,
    val name:String,
    val height: Int,
    val weight: Int
)
