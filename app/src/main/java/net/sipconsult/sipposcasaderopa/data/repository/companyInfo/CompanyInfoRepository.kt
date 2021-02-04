package net.sipconsult.sipposcasaderopa.data.repository.companyInfo

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.CompanyInfoItem

interface CompanyInfoRepository {

    val companyInfo: LiveData<CompanyInfoItem>
}