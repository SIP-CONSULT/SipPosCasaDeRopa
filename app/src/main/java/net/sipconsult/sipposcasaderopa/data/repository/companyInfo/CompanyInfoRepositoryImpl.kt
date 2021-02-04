package net.sipconsult.sipposcasaderopa.data.repository.companyInfo

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.datasource.companyInfo.local.CompanyInfoLocalDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.companyInfo.network.CompanyInfoNetworkDataSource
import net.sipconsult.sipposcasaderopa.data.models.CompanyInfoItem

class CompanyInfoRepositoryImpl(
    private val networkDataSource: CompanyInfoNetworkDataSource,
    private val localDataSource: CompanyInfoLocalDataSource
) : CompanyInfoRepository {
    override val companyInfo: LiveData<CompanyInfoItem>
        get() = TODO("Not yet implemented")
}