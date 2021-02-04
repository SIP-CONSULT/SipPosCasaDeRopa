package net.sipconsult.sipposcasaderopa.data.models


import com.google.gson.annotations.SerializedName

data class SalesTransactionPostProduct(
    @SerializedName("productId")
    val productId: Int,
    @SerializedName("quantity")
    val quantity: Int
)