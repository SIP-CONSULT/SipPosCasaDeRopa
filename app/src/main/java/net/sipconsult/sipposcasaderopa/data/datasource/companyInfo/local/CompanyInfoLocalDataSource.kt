package net.sipconsult.sipposcasaderopa.data.datasource.companyInfo.local

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.CompanyInfoItem

interface CompanyInfoLocalDataSource {

    val companyInfo: LiveData<CompanyInfoItem>

    fun updateCompanyInfo(companyInfoItem: CompanyInfoItem)
}