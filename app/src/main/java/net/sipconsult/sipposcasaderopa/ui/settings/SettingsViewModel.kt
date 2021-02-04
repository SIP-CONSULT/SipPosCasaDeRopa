package net.sipconsult.sipposcasaderopa.ui.settings

import androidx.lifecycle.ViewModel
import net.sipconsult.sipposcasaderopa.data.repository.location.LocationRepository
import net.sipconsult.sipposcasaderopa.internal.lazyDeferred

class SettingsViewModel(
    private val locationRepository: LocationRepository
) : ViewModel() {

    val locations by lazyDeferred {
        locationRepository.getLocations()
    }

//    val locations = liveData(Dispatchers.IO) {
//        val locations=  locationRepository.getLocations()
//
//        emit(locations)
//
//    }
}