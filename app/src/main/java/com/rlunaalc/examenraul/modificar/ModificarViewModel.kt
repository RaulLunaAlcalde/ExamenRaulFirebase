package com.rlunaalc.examenraul.modificar

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class ModificarViewModel : ViewModel() {
    fun actualizarProducto(context: Context, productId: String, nuevoNombre: String, nuevoPrecio: Double) {
        val db = FirebaseFirestore.getInstance()
        val productoRef = db.collection("productos").document(productId)

        val updates = mapOf(
            "nom" to nuevoNombre,
            "preu" to nuevoPrecio
        )

        productoRef.update(updates)
            .addOnSuccessListener { Toast.makeText(context, "Producto actualizado correctamente!", Toast.LENGTH_SHORT).show() }
            .addOnFailureListener { e -> Toast.makeText(context, "Error : $e", Toast.LENGTH_SHORT).show() }
    }


    fun eliminarProducto(context: Context, productId: String) {
        val db = FirebaseFirestore.getInstance()
        val productoRef = db.collection("productos").document(productId)

        productoRef.delete()
            .addOnSuccessListener { Toast.makeText(context, "Producto eliminado correctamente correctamente!", Toast.LENGTH_SHORT).show() }
            .addOnFailureListener { e -> Toast.makeText(context, "Error : $e", Toast.LENGTH_SHORT).show() }
    }
}