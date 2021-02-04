package net.sipconsult.sipposcasaderopa.data.repository.paymentMethod

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.PaymentMethodItem
import net.sipconsult.sipposcasaderopa.data.models.Voucher
import net.sipconsult.sipposcasaderopa.internal.Result

interface PaymentMethodRepository {
    suspend fun getPaymentMethods(): LiveData<List<PaymentMethodItem>>
    suspend fun getVoucher(code: String): Result<Voucher>
}