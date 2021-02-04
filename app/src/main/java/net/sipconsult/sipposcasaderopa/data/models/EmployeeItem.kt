package net.sipconsult.sipposcasaderopa.data.models


import com.google.gson.annotations.SerializedName

data class EmployeeItem(
    @SerializedName("code")
    val code: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("gender")
    val gender: GenderItem,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("middleName")
    val middleName: String?,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("type")
    val type: EmployeeTypeItem
)