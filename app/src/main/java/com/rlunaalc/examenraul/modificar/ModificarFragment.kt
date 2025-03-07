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

        /*binding.modificarButton.setOnClickListener {
            val nom = binding.nomInput.editText?.text.toString()
            val preu = binding.preuInput.editText?.text.toString().toIntOrNull()
            val id = binding.idInput.editText?.text.toString().toLongOrNull()

            if (!nom.isNullOrBlank() && preu != null && id != null) {
                modificarViewModel.modificarProducte(requireContext(), nom, preu, id)
            } else {
                Toast.makeText(requireContext(), "Emplena els camps!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.eliminarButton.setOnClickListener {
            val id = binding.idInput.editText?.text.toString().toLongOrNull()

            if (id != null) {
                modificarViewModel.eliminarProducte(requireContext(), id)
            } else {
                Toast.makeText(requireContext(), "Emplena els camps!", Toast.LENGTH_SHORT).show()
            }
        }*/


        return binding.root
    }


}