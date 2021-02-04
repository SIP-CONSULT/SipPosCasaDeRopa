package net.sipconsult.sipposcasaderopa.data.network.response


import com.google.gson.annotations.SerializedName
import net.sipconsult.sipposcasaderopa.data.models.LoggedInUser

data class LoginResponse(
    @SerializedName("error")
    val error: String,
    @SerializedName("successful")
    val successful: Boolean,
    @SerializedName("employee")
    val user: LoggedInUser
)