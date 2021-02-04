package net.sipconsult.sipposcasaderopa.data.repository

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.ClientItem

interface ClientRepository {
    suspend fun getClients(): LiveData<List<ClientItem>>

    fun getClientsLocal(): LiveData<List<ClientItem>>
}