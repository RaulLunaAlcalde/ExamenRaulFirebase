package com.rlunaalc.examenraul

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.rlunaalc.examenraul.dataBase.Producte
import com.rlunaalc.examenraul.modificar.ModificarFragment

class ProducteAdapter (private val producte: List<Producte>,
    ):RecyclerView.Adapter<ProducteAdapter.ProducteViewHolder>(){

        class ProducteViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val producteNom: TextView = view.findViewById(R.id.ProducteNom)
            val productePreu: TextView = view.findViewById(R.id.ProductePreu)
            val producteId: TextView = view.findViewById(R.id.ProducteId)
            val layoutCardView = view.findViewById<View>(R.id.layoutCardView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProducteViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.producte_cardview, parent, false)
            return ProducteViewHolder(view)
        }

        override fun onBindViewHolder(holder: ProducteViewHolder, position: Int) {
            val producte = producte[position]
            holder.producteNom.text = producte.nom
            holder.productePreu.text = producte.preu.toString()
            holder.producteId.text = producte.id.toString()

            holder.layoutCardView.setOnClickListener {view ->
                view.findNavController().navigate(R.id.action_llistarFragment_to_modificarFragment)
            }
        }

        override fun getItemCount(): Int = producte.size

    }