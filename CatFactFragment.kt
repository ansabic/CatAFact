package com.example.catafact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.catafact.databinding.CatFactFragmentBinding

class CatFactFragment : Fragment() {


    private val viewModel = CatFactViewModel()
    private var _binding: CatFactFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CatFactFragmentBinding.inflate(layoutInflater, container, false)
        observe()
        listen()
        inflateWithFact()
        return binding.root
    }

    private fun inflateWithFact() {
        viewModel.getRandomFact()
    }

    private fun listen() {
        binding.button.setOnClickListener {
            viewModel.getRandomFact()
        }
    }

    private fun observe() {
        viewModel.randomFact.observe(viewLifecycleOwner) {
            binding.quoteTv.text = it ?: "Failed to get a fact!"
        }
    }

}