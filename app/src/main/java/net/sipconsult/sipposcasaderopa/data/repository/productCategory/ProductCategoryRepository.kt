package net.sipconsult.sipposcasaderopa.data.repository.productCategory

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.ProductCategoryItem

interface ProductCategoryRepository {
    suspend fun getCategories(): LiveData<List<ProductCategoryItem>>
}