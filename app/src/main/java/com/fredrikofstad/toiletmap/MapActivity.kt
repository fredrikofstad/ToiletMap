package com.fredrikofstad.toiletmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.fredrikofstad.toiletmap.databinding.ActivityMapBinding
import com.fredrikofstad.toiletmap.models.UserMap
import com.google.android.gms.maps.model.LatLngBounds

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapBinding
    private lateinit var userMap: UserMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userMap = intent.getSerializableExtra(USER_MAP) as UserMap
        supportActionBar?.title = userMap.title

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val markerBounds = LatLngBounds.Builder()
        //add markers for toilets
        for(toilet in userMap.toilets){
            val location = LatLng(toilet.latitude, toilet.longitude)
            markerBounds.include(location)
            mMap.addMarker(MarkerOptions().position(location).title(toilet.title).snippet(toilet.description))
        }
        //move camera to markers
        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(markerBounds.build(),1000,1000,0))
    }
}