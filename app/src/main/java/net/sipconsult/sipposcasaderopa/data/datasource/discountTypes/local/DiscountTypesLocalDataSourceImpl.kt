package net.sipconsult.sipposcasaderopa.data.datasource.discountTypes.local

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.db.DiscountTypeDao
import net.sipconsult.sipposcasaderopa.data.models.DiscountTypesItem

class DiscountTypesLocalDataSourceImpl(private val discountTypeDao: DiscountTypeDao) :
    DiscountTypesLocalDataSource {

    override val discountTypes: LiveData<List<DiscountTypesItem>>
        get() = discountTypeDao.getDiscountTypes

    override fun updateDiscountTypes(discountTypes: List<DiscountTypesItem>) {
        discountTypeDao.deleteAll()
        discountTypeDao.upsertAll(discountTypes)
    }
}