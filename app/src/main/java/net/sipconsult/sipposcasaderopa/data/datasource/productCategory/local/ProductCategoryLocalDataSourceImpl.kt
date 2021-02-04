package net.sipconsult.sipposcasaderopa.data.datasource.productCategory.local

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.db.ProductCategoryDao
import net.sipconsult.sipposcasaderopa.data.models.ProductCategoryItem

class ProductCategoryLocalDataSourceImpl(private val productCategoryDao: ProductCategoryDao) :
    ProductCategoryLocalDataSource {

    override val productCategories: LiveData<List<ProductCategoryItem>>
        get() = productCategoryDao.getProductCategories

    override fun updateProductCategories(productCategories: List<ProductCategoryItem>) {
        productCategoryDao.deleteAll()
        productCategoryDao.upsertAll(productCategories)
    }
}