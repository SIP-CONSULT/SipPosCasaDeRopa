package net.sipconsult.sipposcasaderopa.ui.transactions

import net.sipconsult.sipposcasaderopa.data.network.response.SalesTransactions


data class SaleTransactionsResult(
    val success: SalesTransactions? = null,
    val error: Int? = null
)