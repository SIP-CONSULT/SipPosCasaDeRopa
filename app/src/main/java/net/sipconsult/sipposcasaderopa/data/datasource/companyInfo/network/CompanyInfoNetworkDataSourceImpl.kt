package net.sipconsult.sipposcasaderopa.data.datasource.companyInfo.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import net.sipconsult.sipposcasaderopa.data.models.CompanyInfoItem
import net.sipconsult.sipposcasaderopa.data.network.SipShopApiService
import net.sipconsult.sipposcasaderopa.internal.NoConnectivityException

class CompanyInfoNetworkDataSourceImpl(
    private val sipShopApiService: SipShopApiService
) : CompanyInfoNetworkDataSource {

    private val _downloadCompanyInfo = MutableLiveData<CompanyInfoItem>()

    override val downloadCompanyInfo: LiveData<CompanyInfoItem>
        get() = _downloadCompanyInfo

    override suspend fun fetchCompanyInfo() {
        try {
            val discountTypes = sipShopApiService.getCompanyInfoAsync()
            _downloadCompanyInfo.postValue(discountTypes)
        } catch (e: NoConnectivityException) {
            Log.d(TAG, "fetchProducts: No internet Connection ", e)
        }
    }

    companion object {
        private const val TAG: String = "CompanyInfoNetDataSrc"
    }
}