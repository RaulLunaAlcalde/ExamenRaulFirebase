package com.rlunaalc.examenraul.modificar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.rlunaalc.examenraul.R
import com.rlunaalc.examenraul.databinding.FragmentModificarBinding

class ModificarFragment : Fragment() {

    private lateinit var binding: FragmentModificarBinding
    private lateinit var modificarViewModel: ModificarViewModel

    private val args: ModificarFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentModificarBinding.inflate(inflater, container, false)
        modificarViewModel = ViewModelProvider(this)[ModificarViewModel::class.java]

        val producteId = args.producteId

        binding.idInput.editText?.setText(producteId)

        binding.modificarButton.setOnClickListener {
            val nom = binding.nomInput.editText?.text.toString()
            val preu = binding.preuInput.editText?.text.toString().toDoubleOrNull()

            if (!nom.isNullOrBlank() && preu != null) {
                modificarViewModel.actualizarProducto(requireContext(), producteId, nom, preu)
                findNavController().navigate(R.id.llistarFragment)
            } else {
                Toast.makeText(requireContext(), "Emplena els camps!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.eliminarButton.setOnClickListener {
            if (producteId.isNullOrBlank()) {
                Toast.makeText(requireContext(), "Emplena els camps!", Toast.LENGTH_SHORT).show()
            } else {
                modificarViewModel.eliminarProducto(requireContext(), producteId)
            }
        }

        return binding.root
    }
}
