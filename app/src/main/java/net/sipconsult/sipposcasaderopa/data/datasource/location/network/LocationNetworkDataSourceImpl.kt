package net.sipconsult.sipposcasaderopa.data.datasource.location.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import net.sipconsult.sipposcasaderopa.data.network.SipShopApiService
import net.sipconsult.sipposcasaderopa.data.network.response.Locations
import net.sipconsult.sipposcasaderopa.internal.NoConnectivityException

class LocationNetworkDataSourceImpl(
    private val sipShopApiService: SipShopApiService
) : LocationNetworkDataSource {

    private val _downloadLocations = MutableLiveData<Locations>()

    override val downloadLocations: LiveData<Locations>
        get() = _downloadLocations

    override suspend fun fetchLocations() {
        try {
            val fetchedProducts = sipShopApiService.getLocationsAsync()
            _downloadLocations.postValue(fetchedProducts)
        } catch (e: NoConnectivityException) {
            Log.d(TAG, "fetchProducts: No internet Connection ", e)
        }
    }

    companion object {
        private const val TAG: String = "LocatoinNetworkDataSrc"
    }
}