package net.sipconsult.sipposcasaderopa.data.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

class ServiceItem(
    @SerializedName("description")
    @ColumnInfo(name = "service_description")
    val description: String,

    @SerializedName("code")
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "service_code")
    val code: String,

    @SerializedName("imageUrl")
    @ColumnInfo(name = "image_url")
    val imageUrl: String,

    @SerializedName("price")
    @Embedded
    val price: Price
) {
    fun displaySalesPrice(): String? {
        return String.format("GHC %.2f ", price.salePrice)

    }
}