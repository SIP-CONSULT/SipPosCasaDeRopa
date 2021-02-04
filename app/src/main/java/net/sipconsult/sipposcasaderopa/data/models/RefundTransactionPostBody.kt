package net.sipconsult.sipposcasaderopa.data.models

import com.google.gson.annotations.SerializedName

data class RefundTransactionPostBody(
    @SerializedName("salesTransactionId")
    val salesTransactionId: Int,
    @SerializedName("operatorUserId")
    val operatorUserId: String,
    @SerializedName("ReceiptNumber")
    val receiptNumber: String,
    @SerializedName("locationId")
    val locationId: Int,
    @SerializedName("refundTransactionPaymentMethod")
    val refundTransactionPaymentMethod: List<RefundTransactionPostPaymentMethod>,
    @SerializedName("refundTransactionProduct")
    val refundTransactionProduct: List<RefundTransactionPostProduct>
)