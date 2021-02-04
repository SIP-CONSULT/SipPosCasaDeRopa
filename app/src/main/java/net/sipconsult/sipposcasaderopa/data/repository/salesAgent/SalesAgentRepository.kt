package net.sipconsult.sipposcasaderopa.data.repository.salesAgent

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.SalesAgentsItem

interface SalesAgentRepository {
    suspend fun getSalesAgents(): LiveData<List<SalesAgentsItem>>
    fun getSalesAgent(salesAgentId: Int): SalesAgentsItem
    fun getSalesAgentsLocal(): LiveData<List<SalesAgentsItem>>
}