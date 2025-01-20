package com.rlunaalc.examenraul.inserir

import android.content.Context
import androidx.lifecycle.ViewModel
import com.rlunaalc.examenraul.Repositori
import com.rlunaalc.examenraul.dataBase.Producte

class InserirViewModel : ViewModel() {

    fun introduir_productes(context: Context, nom: String, preu: Int?){
        val alumne = Producte(nom, preu)
        Repositori.inserirAlumne(context, alumne)
    }

}