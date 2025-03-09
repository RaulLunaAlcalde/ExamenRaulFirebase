package com.rlunaalc.examenraul.llistar

import ProducteAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.rlunaalc.examenraul.R
import com.rlunaalc.examenraul.dataBase.Producte
import com.rlunaalc.examenraul.databinding.FragmentInserirBinding
import com.rlunaalc.examenraul.databinding.FragmentLlistarBinding

class LlistarFragment : Fragment() {
    private lateinit var binding: FragmentLlistarBinding
    private lateinit var producteAdapter: ProducteAdapter
    private val productesList = mutableListOf<Producte>()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLlistarBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        producteAdapter = ProducteAdapter(productesList)
        binding.recyclerView.adapter = producteAdapter

        carregarProductes()

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.inserirFragment)
        }

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun carregarProductes() {
        db.collection("productos")
            .get()
            .addOnSuccessListener { documents ->
                productesList.clear()
                for (document in documents) {
                    val producte = document.toObject(Producte::class.java)
                    producte.id = document.id
                    productesList.add(producte)
                }
                producteAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(requireContext(), "Error: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }

}
