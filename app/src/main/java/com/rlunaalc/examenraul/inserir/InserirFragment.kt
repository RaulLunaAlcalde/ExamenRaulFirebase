package com.rlunaalc.examenraul.inserir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.rlunaalc.examenraul.R
import com.rlunaalc.examenraul.databinding.FragmentInserirBinding


class InserirFragment : Fragment() {
    private lateinit var binding: FragmentInserirBinding
    private lateinit var introduirViewModel: InserirViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInserirBinding.inflate(inflater, container, false)
        introduirViewModel = ViewModelProvider(this)[InserirViewModel::class.java]

        binding.insertButton.setOnClickListener {
            introduirViewModel.introduir_productes(
                requireContext(),
                nom = binding.nomInput.editText?.text.toString(),
                preu = binding.preuInput.editText?.text.toString().toIntOrNull(),
            )
            Toast.makeText(requireContext(), "insert realitzat correctament", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.llistarFragment)
        }


        return binding.root
    }
}