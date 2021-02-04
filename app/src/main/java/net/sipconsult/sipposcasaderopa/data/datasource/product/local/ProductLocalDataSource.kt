package net.sipconsult.sipposcasaderopa.data.datasource.product.local

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.ProductItem

interface ProductLocalDataSource {
    val products: LiveData<List<ProductItem>>

    fun productsCategory(categoryId: Int): LiveData<List<ProductItem>>

    fun updateProducts(products: List<ProductItem>)
}