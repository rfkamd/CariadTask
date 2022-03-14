package com.cariad.app.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.cariad.app.R
import com.cariad.app.databinding.ActivityMapsBinding
import com.cariad.app.models.POI
import com.cariad.app.ui.bottomsheets.POIDetailBottomsheet
import com.cariad.app.utils.Status
import com.cariad.app.viewmodels.MapsViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private val mapsViewModel: MapsViewModel by viewModel()
    private lateinit var mapFragment: SupportMapFragment

    private var markerMap = HashMap<Marker, POI>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initListeners()
        initObservers()

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnMarkerClickListener(this)
    }

    private fun initViews() {
        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
    }

    private fun initListeners() {
        mapFragment.getMapAsync(this)
    }

    private fun initObservers() {
        mapsViewModel.pois.observe(this, Observer {
            when (it!!.status) {
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE

                    if(it != null && it!!.data != null){
                        mMap.clear()
                        it!!.data!!.forEach {
                            val loc = LatLng(it!!.AddressInfo!!.Latitude!!, it!!.AddressInfo!!.Longitude!!)
                            var marker = mMap.addMarker(MarkerOptions().position(loc))
                            markerMap.put(marker!!, it!!)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(loc))
                        }
                    }
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                }

            }
        })
    }

    override fun onMarkerClick(marker: Marker): Boolean {
        var station = markerMap.get(marker)
        POIDetailBottomsheet.instance(station!!)
            .show(getSupportFragmentManager(), POIDetailBottomsheet.TAG)
        return true
    }

}