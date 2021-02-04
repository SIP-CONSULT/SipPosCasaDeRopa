package net.sipconsult.sipposcasaderopa.ui.transactions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.sipconsult.sipposcasaderopa.R
import net.sipconsult.sipposcasaderopa.data.network.response.SalesTransactions
import net.sipconsult.sipposcasaderopa.data.provider.LocationProvider
import net.sipconsult.sipposcasaderopa.data.repository.transaction.TransactionRepository
import net.sipconsult.sipposcasaderopa.internal.Result
import net.sipconsult.sipposcasaderopa.internal.lazyDeferred

class SalesTransactionViewModel(
    private val transactionRepository: TransactionRepository,
    private val locationProvider: LocationProvider
) :
    ViewModel() {

    private val locationCode = locationProvider.getLocation()

    private val _transactionResult = MutableLiveData<SaleTransactionsResult>()
    val transactionsResult: LiveData<SaleTransactionsResult> = _transactionResult

    val getSaleTransactions by lazyDeferred {
        transactionRepository.fetchLocationSaleTransactions(locationCode)
    }

    fun updateTransactionResult(result: Result<SalesTransactions>) {
        if (result is Result.Success) {
            _transactionResult.value =
                SaleTransactionsResult(
                    success = result.data
                )
        } else {
            _transactionResult.value =
                SaleTransactionsResult(error = R.string.voucher_failed)
        }
    }
}