package net.sipconsult.sipposcasaderopa.ui.transactions.refund

import net.sipconsult.sipposcasaderopa.data.models.SalesTransactionsItem


data class SaleTransactionResult(
    val success: SalesTransactionsItem? = null,
    val error: Int? = null
)