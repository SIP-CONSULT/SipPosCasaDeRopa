package net.sipconsult.sipposcasaderopa.data.datasource.transaction.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import net.sipconsult.sipposcasaderopa.data.models.RefundTransactionPostBody
import net.sipconsult.sipposcasaderopa.data.models.SaleTransactionPostBody
import net.sipconsult.sipposcasaderopa.data.models.SalesTransactionsItem
import net.sipconsult.sipposcasaderopa.data.network.SipShopApiService
import net.sipconsult.sipposcasaderopa.data.network.response.SalesTransactions
import net.sipconsult.sipposcasaderopa.data.network.response.TransactionResponse
import net.sipconsult.sipposcasaderopa.internal.NoConnectivityException
import net.sipconsult.sipposcasaderopa.internal.Result
import java.io.IOException

class TransactionNetworkDataSourceImpl(private val sipShopApiService: SipShopApiService) :
    TransactionNetworkDataSource {
    override suspend fun postTransaction(body: SaleTransactionPostBody): Result<TransactionResponse> {
        try {
            val postTransaction = sipShopApiService.postTransactionAsync(body)

            return if (postTransaction.successful) {
                Result.Success(
                    postTransaction
                )

            } else {
                Result.Error(
                    IOException("Error logging in")
                )
            }
        } catch (e: NoConnectivityException) {
            Log.d(TAG, "postTransaction: No internet Connection ", e)
            return Result.Error(
                IOException("Error logging in", e)
            )
        }
    }

    override suspend fun postRefundTransaction(body: RefundTransactionPostBody): Result<TransactionResponse> {
        try {
            val postTransaction = sipShopApiService.postRefundTransactionAsync(body)

            return if (postTransaction.successful) {
                Result.Success(
                    postTransaction
                )

            } else {
                Result.Error(
                    IOException("Error logging in")
                )
            }
        } catch (e: NoConnectivityException) {
            Log.d(TAG, "postTransaction: No internet Connection ", e)
            return Result.Error(
                IOException("Error logging in", e)
            )
        }
    }

    private val _downloadSaleTransaction = MutableLiveData<SalesTransactions>()

    override val downloadSaleTransaction: LiveData<SalesTransactions>
        get() = _downloadSaleTransaction

    override suspend fun fetchSaleTransaction(transactionId: Int): Result<SalesTransactionsItem> {
        return try {

            val call = sipShopApiService.getTransactionAsync(transactionId)

            Result.Success(
                call
            )

        } catch (e: Throwable) {
            return Result.Error(
                IOException("Error logging in", e)
            )
        }
    }

    override suspend fun fetchSaleTransactions(operatorId: String): Result<SalesTransactions> {
        return try {

            val call = sipShopApiService.getTransactionsAsync(operatorId)

            Result.Success(
                call
            )

        } catch (e: Throwable) {
            return Result.Error(
                IOException("Error logging in", e)
            )
        }
    }

    override suspend fun fetchLocationSaleTransactions(locationId: Int): Result<SalesTransactions> {
        return try {

            val transactions = sipShopApiService.getLocationTransactionsAsync(locationId)

            Result.Success(
                transactions
            )

        } catch (e: Throwable) {
            return Result.Error(
                IOException("Error logging in", e)
            )
        }
    }


    companion object {
        private const val TAG: String = "TransNetworkDataSrc"
    }
}