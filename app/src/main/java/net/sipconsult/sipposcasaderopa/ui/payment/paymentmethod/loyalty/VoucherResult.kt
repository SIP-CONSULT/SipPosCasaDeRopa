package net.sipconsult.sipposcasaderopa.ui.payment.paymentmethod.loyalty

import net.sipconsult.sipposcasaderopa.data.models.Voucher

data class VoucherResult(
    val success: Voucher? = null,
    val error: Int? = null
)