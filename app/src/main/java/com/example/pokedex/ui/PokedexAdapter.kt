package com.example.pokedex.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.data.Pokemon
import com.example.pokedex.databinding.PokedexContentBinding

class PokedexAdapter:ListAdapter<Pokemon, PokedexAdapter.PokemonViewHolder>(PokemonDiffCallback) {
    inner class PokemonViewHolder(private val binding: PokedexContentBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(pokemon: Pokemon){
            binding.pokemonName.text = pokemon.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding:PokedexContentBinding = PokedexContentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object PokemonDiffCallback: DiffUtil.ItemCallback<Pokemon>(){
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon) = oldItem.name == newItem.name
    }
}