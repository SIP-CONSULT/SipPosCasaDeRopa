package net.sipconsult.sipposcasaderopa.data.datasource.paymentMethod.local

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.PaymentMethodItem

interface PaymentMethodLocalDataSource {

    val paymentMethods: LiveData<List<PaymentMethodItem>>

    fun updatePaymentMethods(paymentMethods: List<PaymentMethodItem>)
}