package com.rlunaalc.examenraul.llistar

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
import com.rlunaalc.examenraul.ProducteAdapter
import com.rlunaalc.examenraul.R
import com.rlunaalc.examenraul.databinding.FragmentLlistarBinding

class LlistarFragment : Fragment() {
    private lateinit var binding: FragmentLlistarBinding
    private lateinit var llistarViewModel: LlistarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLlistarBinding.inflate(inflater, container, false)

        llistarViewModel = ViewModelProvider(this)[LlistarViewModel::class.java]
        llistarViewModel.llistar_productes(requireContext())
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        llistarViewModel.llistat_productes?.observe(viewLifecycleOwner, Observer {
                producteLlistat -> binding.recyclerView.adapter = ProducteAdapter(producteLlistat)
        })

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.inserirFragment)
        }

        return binding.root
    }
}