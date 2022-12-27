package space.beka.mymap

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import space.beka.mymap.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    lateinit var marker: Marker
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
        val codial = LatLng(40.38305896159009, 71.78271168663265)
        mMap.addMarker(MarkerOptions().position(codial).title("Marker in Codial"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(codial))
        // Add a marker in Sydney and move the camera
        val cameraPosition = CameraPosition.Builder()
        cameraPosition.target(codial)
        cameraPosition.bearing(90f)
        cameraPosition.tilt(0f)
        cameraPosition.zoom(15f)
//        mMap.addMarker(MarkerOptions().title("Our marker").position(codial))
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition.build()))
        marker = mMap.addMarker(MarkerOptions().position(codial))!!
        mMap.setOnMarkerClickListener {
            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
            true
        }


//        mMap.setOnMapClickListener {
//            mMap.addMarker(MarkerOptions().title("It is a marker").position(codial))
//        }



        //        mMap.setOnMapLongClickListener {   val cameraPosition = CameraPosition.Builder()
        //            cameraPosition.target(it)
        ////            cameraPosition.bearing(90f)
        //            cameraPosition.tilt(0f)
        //            cameraPosition.zoom(15f)
        //            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition.build()))
        //
        //        }


    }

}