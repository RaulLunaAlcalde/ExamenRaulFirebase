package com.rlunaalc.examenraul.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Producte::class],
    version = 1,
    exportSchema = false
)

abstract class dataBase : RoomDatabase() {

    abstract fun productesDAO(): ProductesDAO

    companion object {

        @Volatile
        private var INSTANCE: dataBase? = null

        fun getDatabase(context: Context): dataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        // todo funcion para crear base de datos en caso de que no queramos tener datos

        /*private fun buildDatabase(context: Context): dataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                dataBase::class.java,
                "productes_database"
            )
                .build()
        }*/

        // todo funcion para importar una base de datos con datos dentro

        private fun buildDatabase(context: Context): dataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                dataBase::class.java,
                "cotxes_database"
            )
                .createFromAsset("database/productes_database.db").build()
        }

    }

}