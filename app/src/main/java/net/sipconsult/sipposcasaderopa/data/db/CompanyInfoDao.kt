package net.sipconsult.sipposcasaderopa.data.db

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.sipconsult.sipposcasaderopa.data.models.COMPANY_INFO_ID
import net.sipconsult.sipposcasaderopa.data.models.CompanyInfoItem

interface CompanyInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertAll(companyInfo: CompanyInfoItem)

    @Query("SELECT * FROM company_info WHERE id = $COMPANY_INFO_ID")
    fun getCompanyInfo(): LiveData<CompanyInfoItem>

    @get:Query("SELECT * FROM company_info")
    val getProductCategories: LiveData<List<CompanyInfoItem>>

    @Query("DELETE FROM company_info")
    fun deleteAll()
}