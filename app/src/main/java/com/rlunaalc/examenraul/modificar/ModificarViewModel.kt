package com.rlunaalc.examenraul.modificar

import android.content.Context
import androidx.lifecycle.ViewModel
import com.rlunaalc.examenraul.Repositori

class ModificarViewModel : ViewModel() {

    fun modificarProducte(context: Context, nom: String, preu: Int, id: Long){
        Repositori.modificarProducte(context, nom, preu, id)
    }

    fun eliminarProducte(context: Context, id: Long){
        Repositori.eliminarProducte(context, id)
    }

}