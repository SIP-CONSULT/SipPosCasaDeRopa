package net.sipconsult.sipposcasaderopa.data.datasource.client.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import net.sipconsult.sipposcasaderopa.data.network.SipShopApiService
import net.sipconsult.sipposcasaderopa.data.network.response.Clients
import net.sipconsult.sipposcasaderopa.internal.NoConnectivityException

class ClientNetworkDataSourceImpl(private val sipShopApiService: SipShopApiService) :
    ClientNetworkDataSource {

    private val _downloadClients = MutableLiveData<Clients>()

    override val downloadClients: LiveData<Clients>
        get() = _downloadClients

    override suspend fun fetchClients() {
        try {
            val fetchedClients = sipShopApiService.getClientsAsync()
            _downloadClients.postValue(fetchedClients)
        } catch (e: NoConnectivityException) {
            Log.d(TAG, "fetchProducts: No internet Connection ", e)
        }
    }

    companion object {
        private const val TAG: String = "ClientNetworkDataSrc"
    }
}