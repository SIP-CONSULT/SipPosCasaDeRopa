package net.sipconsult.sipposcasaderopa.data.datasource.companyInfo.network

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.CompanyInfoItem

interface CompanyInfoNetworkDataSource {
    val downloadCompanyInfo: LiveData<CompanyInfoItem>

    suspend fun fetchCompanyInfo()
}