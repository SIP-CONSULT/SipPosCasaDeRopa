package net.sipconsult.sipposcasaderopa.data.models

import com.google.gson.annotations.SerializedName

class RefundTransactionPostProduct(
    @SerializedName("productCode")
    val productId: Int,
    @SerializedName("quantity")
    val quantity: Int
)