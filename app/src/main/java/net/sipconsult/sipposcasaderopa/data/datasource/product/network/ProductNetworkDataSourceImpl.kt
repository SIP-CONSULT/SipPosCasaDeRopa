package net.sipconsult.sipposcasaderopa.data.datasource.product.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import net.sipconsult.sipposcasaderopa.data.network.SipShopApiService
import net.sipconsult.sipposcasaderopa.data.network.response.Products
import net.sipconsult.sipposcasaderopa.internal.NoConnectivityException

class ProductNetworkDataSourceImpl(
    private val sipShopApiService: SipShopApiService
) : ProductNetworkDataSource {

    private val _downloadProducts = MutableLiveData<Products>()

    override val downloadProducts: LiveData<Products>
        get() = _downloadProducts

    override suspend fun fetchProducts() {
        try {
            val fetchedProducts = sipShopApiService.getProductsAsync()
            _downloadProducts.postValue(fetchedProducts)
        } catch (e: NoConnectivityException) {
            Log.d(TAG, "fetchProducts: No internet Connection ", e)
        }
    }

    companion object {
        private const val TAG: String = "ProductNetworkDataSrc"
    }
}