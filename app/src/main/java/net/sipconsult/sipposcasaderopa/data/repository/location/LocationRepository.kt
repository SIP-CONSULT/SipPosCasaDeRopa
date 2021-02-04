package net.sipconsult.sipposcasaderopa.data.repository.location

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.LocationsItem

interface LocationRepository {

    suspend fun getLocations(): LiveData<List<LocationsItem>>
    fun getLocation(locationId: Int): LocationsItem
    fun getLocationsLocal(): LiveData<List<LocationsItem>>
}