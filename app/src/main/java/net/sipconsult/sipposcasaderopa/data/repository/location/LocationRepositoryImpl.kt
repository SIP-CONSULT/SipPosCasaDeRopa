package net.sipconsult.sipposcasaderopa.data.repository.location

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.sipconsult.sipposcasaderopa.data.datasource.location.local.LocationLocalDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.location.network.LocationNetworkDataSource
import net.sipconsult.sipposcasaderopa.data.models.LocationsItem

class LocationRepositoryImpl(
    private val networkDataSource: LocationNetworkDataSource,
    private val localDataSource: LocationLocalDataSource
) : LocationRepository {

    init {
        networkDataSource.downloadLocations.observeForever { currentLocations ->
            persistFetchedLocations(currentLocations)
        }
    }

    override suspend fun getLocations(): LiveData<List<LocationsItem>> {
        return withContext(Dispatchers.IO) {
            initLocationsData()
            return@withContext localDataSource.locations
        }
    }

    override fun getLocation(locationId: Int): LocationsItem {
        val location = localDataSource.location(locationId)
        return location
    }


    override fun getLocationsLocal(): LiveData<List<LocationsItem>> {
        return localDataSource.locations
    }

    private fun persistFetchedLocations(fetchedLocations: List<LocationsItem>) {
        GlobalScope.launch(Dispatchers.IO) {
            localDataSource.updateLocations(fetchedLocations)
        }
    }

    private suspend fun initLocationsData() {
        fetchLocations()

    }

    private suspend fun fetchLocations() {
        networkDataSource.fetchLocations()
    }
}
