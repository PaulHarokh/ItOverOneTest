package by.paulharokh.it

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import by.paulharokh.it.databinding.ActivityMapsBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map_id) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {

        val startPin = LatLng(55.75, 37.65)
        mMap = googleMap
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startPin, 11f))



        getJsonDataFromAsset(this, "pins.json")

        val jsonFileString = getJsonDataFromAsset(applicationContext, "pins.json")

        val listPinType = object : TypeToken<PinsMapper>() {}.type

        val gson = Gson()
        val pinsMapper: PinsMapper = gson.fromJson(jsonFileString, listPinType)

        for (element in pinsMapper.pins) {
            val bufferLoc = LatLng(element.coordinates.lat, element.coordinates.lng)
            val pinIdTitle = element.service + ": " + element.id.toString()
            mMap.addMarker(MarkerOptions().position(bufferLoc).title(pinIdTitle))
        }

    }

    fun toServicesPref(view: android.view.View) {

        val intent = Intent(this@MapsActivity, FilterActivity::class.java)
        startActivity(intent)
    }
}
