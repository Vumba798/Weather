package com.example.weather

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.core.app.ActivityCompat

const val MIN_DISTANCE_CHANGE_FOR_UPDATES = 1000

class GeoLocator(
    private val mContext: Context,
    private val mActivity: Activity
) : LocationListener {
    val MIN_DISTANCE_CHANGE_FOR_UPDATES = 1000f // 1000 meters
    val MIN_TIME_BETWEEN_UPDATES: Long = 1000 * 60 * 10 // 10 minutes


    var latitude = 0.0
    var longitude = 0.0

    val locationManager = mContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager


    @SuppressLint("MissingPermission")
    fun getLocation() : Pair<Double, Double>{
        try {
            val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            val isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

            if (isGpsEnabled && checkFineLocationPermission()) {
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    MIN_TIME_BETWEEN_UPDATES,
                    MIN_DISTANCE_CHANGE_FOR_UPDATES,
                    this
                )
            } else if (isNetworkEnabled && checkCoarseLocationPermission()) {
                locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    MIN_TIME_BETWEEN_UPDATES,
                    MIN_DISTANCE_CHANGE_FOR_UPDATES,
                    this
                )
            }
            locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)?.let {
                latitude = it.latitude
                longitude = it.longitude
            }
        } catch(e: Exception) {
            e.printStackTrace()
        }
        return Pair(latitude, longitude)
    }

    private fun checkCoarseLocationPermission(): Boolean {
        return if(ActivityCompat.checkSelfPermission(
                mContext,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                mActivity,
                arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION),
                0
            )
            false
        } else {
            true
        }
    }

    private fun checkFineLocationPermission(): Boolean {
        return if(ActivityCompat.checkSelfPermission(
                mContext,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                mActivity,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                0
            )
            false
        } else {
            true
        }
    }

    override fun onLocationChanged(p0: Location) {
    }
}