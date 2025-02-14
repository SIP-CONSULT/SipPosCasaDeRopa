package net.sipconsult.sipposcasaderopa.data.datasource.location.local

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.db.LocationDao
import net.sipconsult.sipposcasaderopa.data.models.LocationsItem

class LocationLocalDataSourceImpl(
    private val locationDao: LocationDao
) : LocationLocalDataSource {
    override val locations: LiveData<List<LocationsItem>>
        get() = locationDao.getLocations

    override fun location(locationId: Int): LocationsItem {
        val location = locationDao.getLocation(locationId)
        return location
    }

    override fun updateLocations(locations: List<LocationsItem>) {
        locationDao.deleteAll()
        locationDao.upsertAll(locations)
    }

    companion object {
//        class UpsertAsyncTask(private val locationDao: LocationDao,private val locationId: Int) :
//            AsyncTask<List<ProductItem>, Void, Void>() {
//            override fun doInBackground(vararg params: List<ProductItem>): Void? {
//                return locationDao.getLocation(locationId)
//
//            }
//
//        }


    }
}