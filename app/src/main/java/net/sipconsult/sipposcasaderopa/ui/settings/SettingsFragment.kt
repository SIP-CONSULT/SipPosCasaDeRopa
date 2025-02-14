package net.sipconsult.sipposcasaderopa.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import net.sipconsult.sipposcasaderopa.R
import net.sipconsult.sipposcasaderopa.data.models.LocationsItem
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class SettingsFragment : PreferenceFragmentCompat(), KodeinAware {

    override val kodein by closestKodein()

    private val viewModelFactory: SettingsViewModelFactory by instance()

    private lateinit var viewModel: SettingsViewModel

    private lateinit var listPreference: ListPreference

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        listPreference =
            (preferenceManager.findPreference<Preference>("location") as ListPreference?)!!

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(SettingsViewModel::class.java)

        val entries =
            arrayOf<CharSequence>("Tesano - Warehouse 1", "Tesano - Warehouse 2", "Tema")

        val entryValues =
            arrayOf<CharSequence>("TES", "TES2", "TMA")

        val locations = arrayListOf<LocationsItem>(
            LocationsItem(1, "", "", "Tesano - Warehouse 1", ""),
            LocationsItem(2, "", "", "Tesano - Warehouse 2", ""),
            LocationsItem(3, "", "", "Tema", "")
        )

//        viewModel.locations.observe(viewLifecycleOwner, Observer {
//            if (it == null) return@Observer
//            it.observe(viewLifecycleOwner, Observer { locations ->
//                if (locations == null){
//                    for (location in locations){
//                        location.
//                    }
//                }
//            })
//
//        })


//        listPreference.setDefaultValue("TES")
//        listPreference.entries = entries
//        listPreference.entryValues = entryValues

//        listPreference.onPreferenceChangeListener =
//            Preference.OnPreferenceChangeListener { preference, newValue ->
//            }

        return super.onCreateView(inflater, container, savedInstanceState)
    }


}
