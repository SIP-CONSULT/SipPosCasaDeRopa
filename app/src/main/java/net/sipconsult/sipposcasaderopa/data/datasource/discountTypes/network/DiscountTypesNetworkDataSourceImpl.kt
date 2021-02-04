package net.sipconsult.sipposcasaderopa.data.datasource.discountTypes.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import net.sipconsult.sipposcasaderopa.data.network.SipShopApiService
import net.sipconsult.sipposcasaderopa.data.network.response.DiscountTypes
import net.sipconsult.sipposcasaderopa.internal.NoConnectivityException

class DiscountTypesNetworkDataSourceImpl(private val sipShopApiService: SipShopApiService) :
    DiscountTypesNetworkDataSource {

    private val _downloadDiscountTypes = MutableLiveData<DiscountTypes>()
    override val downloadDiscountTypes: LiveData<DiscountTypes>
        get() = _downloadDiscountTypes

    override suspend fun fetchDiscountTypes() {
        try {
            val discountTypes = sipShopApiService.getDiscountTypesAsync()
            _downloadDiscountTypes.postValue(discountTypes)
        } catch (e: NoConnectivityException) {
            Log.d(TAG, "fetchProducts: No internet Connection ", e)
        }
    }

    companion object {
        private const val TAG: String = "DiscountTypesNetDataSrc"
    }
}