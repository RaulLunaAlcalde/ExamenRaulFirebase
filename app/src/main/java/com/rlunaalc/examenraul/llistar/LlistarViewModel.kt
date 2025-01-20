package com.rlunaalc.examenraul.llistar

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rlunaalc.examenraul.Repositori
import com.rlunaalc.examenraul.dataBase.Producte

class LlistarViewModel : ViewModel(){

    private var _llistat_productes: LiveData<List<Producte>>?=null
    val llistat_productes: LiveData<List<Producte>>?
        get() = _llistat_productes

    fun llistar_productes(context: Context){
        _llistat_productes = Repositori.obtenirAlumnes(context)
    }


}