package net.sipconsult.sipposcasaderopa.data.datasource.discountTypes.local

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.DiscountTypesItem

interface DiscountTypesLocalDataSource {

    val discountTypes: LiveData<List<DiscountTypesItem>>

    fun updateDiscountTypes(discountTypes: List<DiscountTypesItem>)
}