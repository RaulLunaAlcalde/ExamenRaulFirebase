package com.rlunaalc.examenraul.modificar

import android.content.Context
import androidx.lifecycle.ViewModel
import com.rlunaalc.examenraul.Repositori

class ModificarViewModel : ViewModel() {

    fun modificarProducte(context: Context, nom: String, preu: Int){
        Repositori.modificarProducte(context, nom, preu)
    }

    fun eliminarProducte(context: Context, nom: String, preu: Int){
        Repositori.eliminarProducte(context, nom)
    }

}