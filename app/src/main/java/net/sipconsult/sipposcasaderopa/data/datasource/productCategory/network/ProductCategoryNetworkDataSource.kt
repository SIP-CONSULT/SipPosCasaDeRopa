package net.sipconsult.sipposcasaderopa.data.datasource.productCategory.network

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.network.response.ProductCategories

interface ProductCategoryNetworkDataSource {

    val downloadProductCategories: LiveData<ProductCategories>

    suspend fun fetchProductCategories()
}