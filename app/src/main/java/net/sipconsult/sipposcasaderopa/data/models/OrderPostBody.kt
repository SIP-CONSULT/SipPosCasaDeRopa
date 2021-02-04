package net.sipconsult.sipposcasaderopa.data.models

import com.google.gson.annotations.SerializedName

class OrderPostBody(
    @SerializedName("OperatorUserId")
    val operatorUserId: String,
    @SerializedName("LocationId")
    val locationId: Int,
    @SerializedName("orderNumber")
    val orderNumber: String,
    @SerializedName("Description")
    val description: String = "",
    @SerializedName("OrderItems")
    val orderItems: List<OrderItemPostBody>
) {
}