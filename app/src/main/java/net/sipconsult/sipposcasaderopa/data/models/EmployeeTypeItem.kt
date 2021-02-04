package net.sipconsult.sipposcasaderopa.data.models


import com.google.gson.annotations.SerializedName

data class EmployeeTypeItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)