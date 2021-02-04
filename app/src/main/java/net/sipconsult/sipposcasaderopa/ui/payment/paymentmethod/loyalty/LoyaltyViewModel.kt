package net.sipconsult.sipposcasaderopa.ui.payment.paymentmethod.loyalty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.sipconsult.sipposcasaderopa.R
import net.sipconsult.sipposcasaderopa.data.models.Voucher
import net.sipconsult.sipposcasaderopa.data.repository.paymentMethod.PaymentMethodRepository
import net.sipconsult.sipposcasaderopa.internal.Result
import net.sipconsult.sipposcasaderopa.internal.lazyDeferred

class LoyaltyViewModel(private val paymentMethodRepository: PaymentMethodRepository) : ViewModel() {

    var voucherCode: String = ""

    private val _voucherResult = MutableLiveData<VoucherResult>()
    val voucherResult: LiveData<VoucherResult> = _voucherResult

    val getVoucher by lazyDeferred {

        // can be launched in a separate asynchronous job
        paymentMethodRepository.getVoucher(voucherCode)

    }

    fun updateVoucherResult(result: Result<Voucher>) {
        if (result is Result.Success) {
            _voucherResult.value =
                VoucherResult(
                    success = result.data
                )
        } else {
            _voucherResult.value =
                VoucherResult(error = R.string.voucher_failed)
        }

    }


}