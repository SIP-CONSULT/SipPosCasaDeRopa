package net.sipconsult.sipposcasaderopa.ui.payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.sipconsult.sipposcasaderopa.data.repository.user.UserRepository

class PaymentViewModelFactory(private val userRepository: UserRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PaymentViewModel(userRepository) as T
    }
}