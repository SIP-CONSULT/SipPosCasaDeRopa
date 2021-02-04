package net.sipconsult.sipposcasaderopa.data.datasource.paymentMethod.network

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.Voucher
import net.sipconsult.sipposcasaderopa.data.network.response.PaymentMethods
import net.sipconsult.sipposcasaderopa.internal.Result

interface PaymentMethodNetworkDataSource {
    val downloadPaymentMethods: LiveData<PaymentMethods>

    suspend fun fetchPaymentMethods()

    suspend fun getVoucher(code: String): Result<Voucher>
}