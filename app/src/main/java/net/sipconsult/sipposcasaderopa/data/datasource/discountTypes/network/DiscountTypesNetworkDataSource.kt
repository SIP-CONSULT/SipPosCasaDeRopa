package net.sipconsult.sipposcasaderopa.data.datasource.discountTypes.network

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.network.response.DiscountTypes

interface DiscountTypesNetworkDataSource {
    val downloadDiscountTypes: LiveData<DiscountTypes>

    suspend fun fetchDiscountTypes()
}