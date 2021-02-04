package net.sipconsult.sipposcasaderopa.data.repository.productCategory

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.sipconsult.sipposcasaderopa.data.datasource.productCategory.local.ProductCategoryLocalDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.productCategory.network.ProductCategoryNetworkDataSource
import net.sipconsult.sipposcasaderopa.data.models.ProductCategoryItem

class ProductCategoryRepositoryImpl(
    private val networkDataSource: ProductCategoryNetworkDataSource,
    private val localDataSource: ProductCategoryLocalDataSource
) : ProductCategoryRepository {

    init {
        networkDataSource.downloadProductCategories.observeForever { currentProductCategories ->
            persistFetchedCategories(currentProductCategories)
        }
    }

    override suspend fun getCategories(): LiveData<List<ProductCategoryItem>> {
        return withContext(Dispatchers.IO) {
            initProductCategoriesData()
            return@withContext localDataSource.productCategories
        }
    }

    private fun persistFetchedCategories(fetchedProductCategories: List<ProductCategoryItem>){
        GlobalScope.launch(Dispatchers.IO) {
            localDataSource.updateProductCategories(fetchedProductCategories)
        }
    }

    private suspend fun initProductCategoriesData() {
        fetchProductCategories()
    }

    private suspend fun fetchProductCategories() {
        networkDataSource.fetchProductCategories()
    }
}