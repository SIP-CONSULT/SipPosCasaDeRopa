package net.sipconsult.sipposcasaderopa.data.datasource.paymentMethod.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import net.sipconsult.sipposcasaderopa.data.models.Voucher
import net.sipconsult.sipposcasaderopa.data.network.SipShopApiService
import net.sipconsult.sipposcasaderopa.data.network.response.PaymentMethods
import net.sipconsult.sipposcasaderopa.internal.NoConnectivityException
import net.sipconsult.sipposcasaderopa.internal.Result
import java.io.IOException

class PaymentMethodNetworkDataSourceImpl(private val sipShopApiService: SipShopApiService) :
    PaymentMethodNetworkDataSource {

    private val _downloadPaymentMethods = MutableLiveData<PaymentMethods>()

    override val downloadPaymentMethods: LiveData<PaymentMethods>
        get() = _downloadPaymentMethods

    override suspend fun fetchPaymentMethods() {
        try {
            val fetchedPaymentMethods = sipShopApiService.getPaymentMethodsAsync()
            _downloadPaymentMethods.postValue(fetchedPaymentMethods)

        } catch (e: NoConnectivityException) {
            Log.d(TAG, "fetchProducts: No internet Connection ", e)
        }
    }

    override suspend fun getVoucher(code: String): Result<Voucher> {
        try {
            val call = sipShopApiService.getVoucherAsync(code)

            return if (call.successful) {
                Result.Success(
                    call.voucher
                )

            } else {
                Result.Error(
                    IOException("Voucher not found")
                )
            }

        } catch (e: Throwable) {
            return Result.Error(
                IOException("Error logging in", e)
            )
        }
    }

    companion object {
        private const val TAG: String = "PaymentMethodNetDataSrc"
    }
}