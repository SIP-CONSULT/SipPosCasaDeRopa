package net.sipconsult.sipposcasaderopa.data.models


import com.google.gson.annotations.SerializedName

data class SaleTransactionPostBody(
    @SerializedName("OperatorId")
    val operatorId: Int,
    @SerializedName("LocationId")
    val locationId: Int,
    @SerializedName("ReceiptNumber")
    val receiptNumber: String,
    @SerializedName("Description")
    val description: String = "",
    @SerializedName("DiscountTypeId")
    var discountTypeId: Int? = null,
    @SerializedName("VoucherId")
    var voucherId: Int? = null,
    @SerializedName("DeliveryCost")
    var deliveryCost: Double? = null,
    @SerializedName("SalesTransactionPaymentMethods")
    val salesTransactionPaymentMethods: List<SalesTransactionPostPaymentMethod>,
    @SerializedName("SalesTransactionProducts")
    val salesTransactionProducts: List<SalesTransactionPostProduct>
)