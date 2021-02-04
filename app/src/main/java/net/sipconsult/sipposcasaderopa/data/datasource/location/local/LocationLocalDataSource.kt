package net.sipconsult.sipposcasaderopa.data.datasource.location.local

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.LocationsItem

interface LocationLocalDataSource {
    val locations: LiveData<List<LocationsItem>>

    fun location(locationId: Int): LocationsItem

    fun updateLocations(locations: List<LocationsItem>)
}