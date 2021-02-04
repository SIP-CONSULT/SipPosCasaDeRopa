package net.sipconsult.sipposcasaderopa.data.datasource.client.local

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.db.ClientsDao
import net.sipconsult.sipposcasaderopa.data.models.ClientItem

class ClientLocalDataSourceImpl(private val clientsDao: ClientsDao) :
    ClientLocalDataSource {
    override val clients: LiveData<List<ClientItem>>
        get() = clientsDao.getClients

    override fun updateClients(clients: List<ClientItem>) {
        clientsDao.upsertAll(clients)
    }
}