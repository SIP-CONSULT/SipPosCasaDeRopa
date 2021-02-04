package net.sipconsult.sipposcasaderopa.data.datasource.client.network

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.network.response.Clients

interface ClientNetworkDataSource {
    val downloadClients: LiveData<Clients>

    suspend fun fetchClients()
}