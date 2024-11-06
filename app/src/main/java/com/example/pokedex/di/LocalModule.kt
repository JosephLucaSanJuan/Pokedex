package com.example.pokedex.di

import android.content.Context
import androidx.room.Room
import com.example.pokedex.data.local.PokemonDao
import com.example.pokedex.data.local.PokemonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context):PokemonDatabase/**/ {
        val database = Room.databaseBuilder(
            context,
            PokemonDatabase::class.java,
            "pokemon-db"
        )
        return database.build()
    }

    @Provides
    fun provideDao(pokemonDatabase:PokemonDatabase): PokemonDao = pokemonDatabase.pokemonDao()/**/
}