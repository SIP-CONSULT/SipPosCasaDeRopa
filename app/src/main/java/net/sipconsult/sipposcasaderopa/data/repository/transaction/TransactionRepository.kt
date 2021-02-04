package net.sipconsult.sipposcasaderopa.data.repository.transaction

import net.sipconsult.sipposcasaderopa.data.models.RefundTransactionPostBody
import net.sipconsult.sipposcasaderopa.data.models.SaleTransactionPostBody
import net.sipconsult.sipposcasaderopa.data.models.SalesTransactionsItem
import net.sipconsult.sipposcasaderopa.data.network.response.SalesTransactions
import net.sipconsult.sipposcasaderopa.data.network.response.TransactionResponse
import net.sipconsult.sipposcasaderopa.internal.Result

interface TransactionRepository {

    suspend fun postTransaction(body: SaleTransactionPostBody): Result<TransactionResponse>

    suspend fun postRefundTransaction(body: RefundTransactionPostBody): Result<TransactionResponse>

    suspend fun fetchSaleTransaction(transactionId: Int): Result<SalesTransactionsItem>

    suspend fun fetchSaleTransactions(operatorId: String): Result<SalesTransactions>

    suspend fun fetchLocationSaleTransactions(locationId: Int): Result<SalesTransactions>
}