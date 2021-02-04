package net.sipconsult.sipposcasaderopa.data.datasource.paymentMethod.local

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.db.PaymentMethodDao
import net.sipconsult.sipposcasaderopa.data.models.PaymentMethodItem

class PaymentMethodLocalDataSourceImpl(private val paymentMethodDao: PaymentMethodDao) :
    PaymentMethodLocalDataSource {
    override val paymentMethods: LiveData<List<PaymentMethodItem>>
        get() = paymentMethodDao.paymentMethods

    override fun updatePaymentMethods(paymentMethods: List<PaymentMethodItem>) {
        paymentMethodDao.deleteAll()
        paymentMethodDao.upsertAll(paymentMethods)
    }
}