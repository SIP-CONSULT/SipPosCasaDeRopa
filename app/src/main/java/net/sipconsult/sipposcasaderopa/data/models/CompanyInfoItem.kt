package net.sipconsult.sipposcasaderopa.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val COMPANY_INFO_ID = 0

@Entity(
    tableName = "company_info"
)
class CompanyInfoItem(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("code")
    val email: String? = "",
    @SerializedName("phoneNumber")
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String? = "",
    @SerializedName("address")
    @ColumnInfo(name = "address")
    val address: String? = ""

)