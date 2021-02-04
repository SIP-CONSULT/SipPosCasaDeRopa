package net.sipconsult.sipposcasaderopa.data.datasource.salesAgent.local

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.SalesAgentsItem

interface SalesAgentLocalDataSource {
    val salesAgents: LiveData<List<SalesAgentsItem>>

    fun salesAgent(salesAgentId: Int): SalesAgentsItem

    fun updateSalesAgent(salesAgents: List<SalesAgentsItem>)
}