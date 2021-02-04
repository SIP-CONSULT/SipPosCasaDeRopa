package net.sipconsult.sipposcasaderopa.data.datasource.productCategory.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import net.sipconsult.sipposcasaderopa.data.network.SipShopApiService
import net.sipconsult.sipposcasaderopa.data.network.response.ProductCategories
import net.sipconsult.sipposcasaderopa.internal.NoConnectivityException

class ProductCategoryNetworkDataSourceImpl(
    private val sipShopApiService: SipShopApiService
) : ProductCategoryNetworkDataSource {

    private val _downloadProductCategories = MutableLiveData<ProductCategories>()

    override val downloadProductCategories: LiveData<ProductCategories>
        get() = _downloadProductCategories

    override suspend fun fetchProductCategories() {
        try {
            val fetchedProductCategories = sipShopApiService.getProductCategoriesAsync()
            _downloadProductCategories.postValue(fetchedProductCategories)
        } catch (e: NoConnectivityException) {
            Log.d(TAG, "fetchProducts: No internet Connection ", e)
        }
    }

    companion object {
        private const val TAG: String = "ProductCatNetDataSrc"
    }
}