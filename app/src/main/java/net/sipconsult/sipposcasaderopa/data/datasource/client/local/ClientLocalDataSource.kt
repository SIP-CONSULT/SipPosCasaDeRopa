package net.sipconsult.sipposcasaderopa.data.datasource.client.local

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.ClientItem

interface ClientLocalDataSource {
    val clients: LiveData<List<ClientItem>>

    fun updateClients(clients: List<ClientItem>)
}