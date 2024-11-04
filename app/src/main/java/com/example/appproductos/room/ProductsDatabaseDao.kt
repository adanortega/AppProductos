/*package com.example.appproductos.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.appproductos.model.Producto
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDatabaseDao{

    @Query("SELECT * FROM PRODUCTS")
    fun getProdcts(): Flow<List<Producto>>

    @Insert (entity = Producto::class, onConflict = OnConflictStrategy.REPLACE )
    suspend fun addProduct(producto: Producto): Long

    @Update(entity = Producto::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateProduct(producto: Producto): Int

    @Delete
    suspend fun deleteProduct(producto: Producto): Int
}*/