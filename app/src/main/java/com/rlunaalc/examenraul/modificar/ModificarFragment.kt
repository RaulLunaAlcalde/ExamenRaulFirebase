package com.rlunaalc.examenraul.modificar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.rlunaalc.examenraul.databinding.FragmentModificarBinding


class ModificarFragment : Fragment() {

    private lateinit var binding: FragmentModificarBinding
    private lateinit var modificarViewModel: ModificarViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentModificarBinding.inflate(inflater, container, false)
        modificarViewModel = ViewModelProvider(this)[ModificarViewModel::class.java]

        binding.modificarButton.setOnClickListener {
            val nom = binding.nomInput.editText?.text.toString()
            val preu = binding.preuInput.editText?.text.toString().toIntOrNull()

            if (!nom.isNullOrBlank() && preu != null) {
                modificarViewModel.modificarProducte(requireContext(), nom, preu)
            } else {
                Toast.makeText(requireContext(), "Emplena els camps!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.eliminarButton.setOnClickListener {
            val nom = binding.nomInput.editText?.text.toString()
            val preu = binding.preuInput.editText?.text.toString().toIntOrNull()

            if (!nom.isNullOrBlank() && preu != null) {
                modificarViewModel.eliminarProducte(requireContext(), nom, preu)
            } else {
                Toast.makeText(requireContext(), "Emplena els camps!", Toast.LENGTH_SHORT).show()
            }
        }


        return binding.root
    }


}