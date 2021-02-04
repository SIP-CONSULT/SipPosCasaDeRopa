package net.sipconsult.sipposcasaderopa.data.repository.product

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.sipconsult.sipposcasaderopa.data.datasource.product.local.ProductLocalDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.product.network.ProductNetworkDataSource
import net.sipconsult.sipposcasaderopa.data.models.ProductItem

class ProductRepositoryImpl(
    private val networkDataSource: ProductNetworkDataSource,
    private val localDataSource: ProductLocalDataSource
) : ProductRepository {

    init {
        networkDataSource.downloadProducts.observeForever { currentProducts ->
            persistFetchedProducts(currentProducts)
        }
    }

    override suspend fun getProducts(): LiveData<List<ProductItem>> {
        return withContext(Dispatchers.IO) {
            initProductsData()
            return@withContext localDataSource.products
        }
    }

    override suspend fun getProductsCategory(categoryId: Int): LiveData<List<ProductItem>> {
        return withContext(Dispatchers.IO) {
            initProductsData()
            return@withContext localDataSource.productsCategory(categoryId)
        }
    }

    override fun getProductsLocal(): LiveData<List<ProductItem>> {
        return localDataSource.products
    }

    private fun persistFetchedProducts(fetchedProducts: List<ProductItem>) {
        GlobalScope.launch(Dispatchers.IO) {
            localDataSource.updateProducts(fetchedProducts)
        }
    }

    private suspend fun initProductsData() {
        fetchProducts()

    }

    private suspend fun fetchProducts() {
        networkDataSource.fetchProducts()
    }
}