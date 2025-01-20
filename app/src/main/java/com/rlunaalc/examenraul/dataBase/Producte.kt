package com.rlunaalc.examenraul.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Producte(
    @ColumnInfo(name = "name")
    var nom: String,
    @ColumnInfo(name = "price")
    var preu: Int?,
){
    @PrimaryKey(autoGenerate = true)
    var id: Long?= null
}