package com.example.pokedex.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentPokedexBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class PokedexFragment : Fragment() {
    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var binding: FragmentPokedexBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokedexBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.pokemonList
        recyclerView.adapter = PokedexAdapter()
        lifecycleScope.launch {
            (recyclerView.adapter as PokedexAdapter).submitList(viewModel.read())
        }
    }
}