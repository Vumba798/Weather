package com.example.weather

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.navigation.compose.rememberNavController
import com.example.weather.ui.navigation.Drawer
import com.example.weather.ui.navigation.NavHost
import com.example.weather.ui.navigation.TopBar
import com.example.weather.ui.theme.Blue
import com.example.weather.ui.theme.WeatherTheme

class MainActivity : ComponentActivity() {
    var coords = Pair(0.0, 0.0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        coords = GeoLocator(mContext = this, mActivity = this).getLocation()
        setContent {
            //TODO change status bar color
            WeatherApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherApp() {
    WeatherTheme {
        val navController = rememberNavController()
        val scope = rememberCoroutineScope()
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopBar(scope = scope, scaffoldState = scaffoldState)
            },
            drawerBackgroundColor = Blue,
            drawerContent = {
                Drawer(
                    scope = scope,
                    scaffoldState = scaffoldState,
                    navController = navController
                )
            }
        ) {
            NavHost(navController = navController)
        }
    }
}
