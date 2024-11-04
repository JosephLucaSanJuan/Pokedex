package com.example.pokedex.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pokemon(
    @PrimaryKey val id:Int = 0,
    @ColumnInfo(name = "name") val name:String
)
