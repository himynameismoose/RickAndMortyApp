package com.example.rickandmortyapp.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.rickandmortyapp.databinding.FragmentCharacterDetailsBinding
import com.example.rickandmortyapp.presenter.state.ViewState
import com.example.rickandmortyapp.presenter.CharacterPresenter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class CharacterDetailsFragment : Fragment() {
    // properties
    private lateinit var binding: FragmentCharacterDetailsBinding
    private val args: CharacterDetailsFragmentArgs by navArgs()
    private val viewModel by viewModels<CharacterPresenter>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.queryCharacter(args.id)
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.character.observe(viewLifecycleOwner) { response ->
            when (response) {
                is ViewState.Loading -> {
                    binding.characterDetailsFetchProgress.visibility = View.VISIBLE
                    binding.characterDetailsNotFound.visibility = View.GONE
                }
                is ViewState.Success -> {
                    if (response.value?.data?.character == null) {
                        binding.characterDetailsFetchProgress.visibility = View.GONE
                        binding.characterDetailsNotFound.visibility = View.VISIBLE
                    } else {
                        binding.query = response.value.data
                        binding.characterDetailsFetchProgress.visibility = View.GONE
                        binding.characterDetailsNotFound.visibility = View.GONE
                    }
                }
                is ViewState.Error -> {
                    binding.characterDetailsFetchProgress.visibility = View.GONE
                    binding.characterDetailsNotFound.visibility = View.VISIBLE
                }
            }
        }
    }
}