package com.rlunaalc.examenraul

import android.content.Context
import androidx.lifecycle.LiveData
import com.rlunaalc.examenraul.dataBase.Producte
import com.rlunaalc.examenraul.dataBase.dataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class Repositori {

    companion object{
        var repositori_database: dataBase? = null
        var producte: LiveData<List<Producte>>? = null

        fun initializeDB(context: Context): dataBase{
            return dataBase.getDatabase(context)
        }

        // todo funcion para llamar al insert de la interfaz AlumnesDAO

        fun inserirAlumne(context: Context, producte: Producte){
            repositori_database = initializeDB(context)

            CoroutineScope(IO).launch {
                repositori_database!!.productesDAO().afegirAlumne(producte)
            }

        }

        // todo funcion para llamar al select de la interfaz AlumnesDAO

        fun obtenirAlumnes(context: Context): LiveData<List<Producte>>? {
            repositori_database = initializeDB(context)

            CoroutineScope(IO).launch {
                producte = repositori_database!!.productesDAO().obtenirAlumne()
            }

            return producte
        }

        fun modificarAlumne(context: Context, nom: String, preu: Int, id: Long) {
            repositori_database = initializeDB(context)

            CoroutineScope(IO).launch {
                repositori_database!!.productesDAO().modificarAlumne(nom, preu, id)
            }
        }
    }
}