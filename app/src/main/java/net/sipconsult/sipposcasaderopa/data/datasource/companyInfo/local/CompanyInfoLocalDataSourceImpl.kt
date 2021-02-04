package net.sipconsult.sipposcasaderopa.data.datasource.companyInfo.local

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.db.CompanyInfoDao
import net.sipconsult.sipposcasaderopa.data.models.CompanyInfoItem

class CompanyInfoLocalDataSourceImpl(
    private val companyInfoDao: CompanyInfoDao
) : CompanyInfoLocalDataSource {
    override val companyInfo: LiveData<CompanyInfoItem>
        get() = companyInfoDao.getCompanyInfo()

    override fun updateCompanyInfo(companyInfoItem: CompanyInfoItem) {
        companyInfoDao.deleteAll()
        companyInfoDao.upsertAll(companyInfoItem)
    }
}