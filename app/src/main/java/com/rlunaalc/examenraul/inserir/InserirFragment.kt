package com.rlunaalc.examenraul.inserir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.rlunaalc.examenraul.R
import com.rlunaalc.examenraul.dataBase.Producte
import com.rlunaalc.examenraul.databinding.FragmentInserirBinding

class InserirFragment : Fragment() {
    private lateinit var binding: FragmentInserirBinding
    private lateinit var introduirViewModel: InserirViewModel
    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInserirBinding.inflate(inflater, container, false)
        introduirViewModel = ViewModelProvider(this)[InserirViewModel::class.java]
        db = FirebaseFirestore.getInstance()

        binding.insertButton.setOnClickListener {
            afegirProducte()
        }

        return binding.root
    }

    private fun afegirProducte() {
        val producteName = binding.nomInput.editText?.text.toString()
        val productePreu = binding.preuInput.editText?.text.toString()

        if (producteName.isEmpty()) {
            Toast.makeText(requireContext(), "Introdueix el nom del producte!", Toast.LENGTH_SHORT).show()
            return
        }
        if (productePreu.isEmpty()) {
            Toast.makeText(requireContext(), "Introdueix el preu del producte!", Toast.LENGTH_SHORT).show()
            return
        }

        val producte = Producte(producteName, productePreu.toLongOrNull())

        db.collection("productos")
            .add(producte)
            .addOnSuccessListener {
                Toast.makeText(requireContext(), "Producte inserit correctament", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { err ->
                Toast.makeText(requireContext(), "Error: ${err.message}", Toast.LENGTH_SHORT).show()
            }
    }
}