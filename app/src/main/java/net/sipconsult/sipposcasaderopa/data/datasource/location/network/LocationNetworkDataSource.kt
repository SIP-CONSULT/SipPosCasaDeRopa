package net.sipconsult.sipposcasaderopa.data.datasource.location.network

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.network.response.Locations

interface LocationNetworkDataSource {
    val downloadLocations: LiveData<Locations>

    suspend fun fetchLocations()
}