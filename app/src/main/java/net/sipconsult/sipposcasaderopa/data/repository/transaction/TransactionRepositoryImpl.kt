package net.sipconsult.sipposcasaderopa.data.repository.transaction

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.sipconsult.sipposcasaderopa.data.datasource.transaction.local.TransactionLocalDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.transaction.network.TransactionNetworkDataSource
import net.sipconsult.sipposcasaderopa.data.models.RefundTransactionPostBody
import net.sipconsult.sipposcasaderopa.data.models.SaleTransactionPostBody
import net.sipconsult.sipposcasaderopa.data.models.SalesTransactionsItem
import net.sipconsult.sipposcasaderopa.data.network.response.SalesTransactions
import net.sipconsult.sipposcasaderopa.data.network.response.TransactionResponse
import net.sipconsult.sipposcasaderopa.internal.Result

class TransactionRepositoryImpl(
    private val localDataSource: TransactionLocalDataSource,
    private val networkDataSource: TransactionNetworkDataSource
) :
    TransactionRepository {

    override suspend fun postTransaction(body: SaleTransactionPostBody): Result<TransactionResponse> {
        return withContext(Dispatchers.IO) {
            return@withContext networkDataSource.postTransaction(body)
        }
    }

    override suspend fun postRefundTransaction(body: RefundTransactionPostBody): Result<TransactionResponse> {
        return withContext(Dispatchers.IO) {
            return@withContext networkDataSource.postRefundTransaction(body)
        }
    }

    override suspend fun fetchSaleTransaction(transactionId: Int): Result<SalesTransactionsItem> {
        return withContext(Dispatchers.IO) {
            return@withContext networkDataSource.fetchSaleTransaction(transactionId)
        }
    }

    override suspend fun fetchSaleTransactions(operatorId: String): Result<SalesTransactions> {
        return withContext(Dispatchers.IO) {
            return@withContext networkDataSource.fetchSaleTransactions(operatorId)
        }
    }

    override suspend fun fetchLocationSaleTransactions(locationId: Int): Result<SalesTransactions> {
        return withContext(Dispatchers.IO) {
            return@withContext networkDataSource.fetchLocationSaleTransactions(locationId)
        }
    }
}