package com.rlunaalc.examenraul.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductesDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun afegirAlumne(producte: Producte)

    @Query("SELECT * FROM products ORDER BY name DESC")
    fun obtenirAlumne(): LiveData<List<Producte>>

    @Query("UPDATE products SET name = :nom, price = :preu where name = :nom")
    fun modificarProducte(nom: String, preu: Int)

    @Query("DELETE FROM products WHERE name = :nom")
    fun eliminarProducte(nom: String)


}