package net.sipconsult.sipposcasaderopa.data.repository.product

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.ProductItem

interface ProductRepository {
    suspend fun getProducts(): LiveData<List<ProductItem>>
    suspend fun getProductsCategory(categoryId: Int): LiveData<List<ProductItem>>
    fun getProductsLocal(): LiveData<List<ProductItem>>

}