package net.sipconsult.sipposcasaderopa.data.datasource.productCategory.local

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.ProductCategoryItem

interface ProductCategoryLocalDataSource {
    val productCategories: LiveData<List<ProductCategoryItem>>

    fun updateProductCategories(productCategories: List<ProductCategoryItem>)
}