package net.sipconsult.sipposcasaderopa.data.datasource.salesAgent.network

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.network.response.SalesAgents

interface SalesAgentNetworkDataSource {

    val downloadSalesAgents: LiveData<SalesAgents>

    suspend fun fetchSalesAgents()
}