package net.sipconsult.sipposcasaderopa.data.repository.discountType

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.DiscountTypesItem

interface DiscountTypeRepository {

    suspend fun getDiscountTypes(): LiveData<List<DiscountTypesItem>>
}