package net.sipconsult.sipposcasaderopa.data.datasource.transaction.network

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.RefundTransactionPostBody
import net.sipconsult.sipposcasaderopa.data.models.SaleTransactionPostBody
import net.sipconsult.sipposcasaderopa.data.models.SalesTransactionsItem
import net.sipconsult.sipposcasaderopa.data.network.response.SalesTransactions
import net.sipconsult.sipposcasaderopa.data.network.response.TransactionResponse
import net.sipconsult.sipposcasaderopa.internal.Result

interface TransactionNetworkDataSource {
    suspend fun postTransaction(body: SaleTransactionPostBody): Result<TransactionResponse>

    suspend fun postRefundTransaction(body: RefundTransactionPostBody): Result<TransactionResponse>

    val downloadSaleTransaction: LiveData<SalesTransactions>

    suspend fun fetchSaleTransaction(transactionId: Int): Result<SalesTransactionsItem>

    suspend fun fetchSaleTransactions(operatorId: String): Result<SalesTransactions>

    suspend fun fetchLocationSaleTransactions(locationId: Int): Result<SalesTransactions>
}