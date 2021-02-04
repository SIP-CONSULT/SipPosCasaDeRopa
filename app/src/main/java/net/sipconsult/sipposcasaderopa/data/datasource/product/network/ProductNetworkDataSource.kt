package net.sipconsult.sipposcasaderopa.data.datasource.product.network

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.network.response.Products

interface ProductNetworkDataSource {
    val downloadProducts: LiveData<Products>

    suspend fun fetchProducts()
}