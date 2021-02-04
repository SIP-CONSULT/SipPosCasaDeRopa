package net.sipconsult.sipposcasaderopa.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.sipconsult.sipposcasaderopa.data.models.ProductItem

@Dao
interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertAll(products: List<ProductItem>)

    @Query("SELECT * FROM products WHERE id = :productId")
    fun getProduct(productId: Int): LiveData<ProductItem>

    @Query("SELECT * FROM products WHERE category_id = :categoryId")
    fun getProductCategory(categoryId: Int): LiveData<List<ProductItem>>

    @get:Query("SELECT * FROM products")
    val getProducts: LiveData<List<ProductItem>>

    @Query("DELETE FROM products")
    fun deleteAll()
}