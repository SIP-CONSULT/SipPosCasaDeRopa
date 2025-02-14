package net.sipconsult.sipposcasaderopa.data.datasource.salesAgent.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import net.sipconsult.sipposcasaderopa.data.network.SipShopApiService
import net.sipconsult.sipposcasaderopa.data.network.response.SalesAgents
import net.sipconsult.sipposcasaderopa.internal.NoConnectivityException

class SalesAgentNetworkDataSourceImpl(
    private val sipShopApiService: SipShopApiService
) : SalesAgentNetworkDataSource {

    private val _downloadSalesAgents = MutableLiveData<SalesAgents>()

    override val downloadSalesAgents: LiveData<SalesAgents>
        get() = _downloadSalesAgents

    override suspend fun fetchSalesAgents() {
        try {
            val fetchedSalesAgents = sipShopApiService.getSalesAgentsAsync()
            _downloadSalesAgents.postValue(fetchedSalesAgents)
        } catch (e: NoConnectivityException) {
            Log.d(TAG, "fetchProducts: No internet Connection ", e)
        }
    }

    companion object {
        private const val TAG: String = "SalesAgentNetDataSrc"
    }
}