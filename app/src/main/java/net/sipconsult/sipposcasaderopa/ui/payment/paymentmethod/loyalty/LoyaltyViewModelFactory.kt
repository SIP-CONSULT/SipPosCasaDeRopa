package net.sipconsult.sipposcasaderopa.ui.payment.paymentmethod.loyalty

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.sipconsult.sipposcasaderopa.data.repository.paymentMethod.PaymentMethodRepository

class LoyaltyViewModelFactory(private val paymentMethodRepository: PaymentMethodRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoyaltyViewModel(paymentMethodRepository) as T
    }
}