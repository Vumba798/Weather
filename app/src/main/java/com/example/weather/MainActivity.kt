package com.example.weather

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.weather.ui.navigation.Drawer
import com.example.weather.ui.navigation.NavDrawerItem
import com.example.weather.ui.navigation.NavHost
import com.example.weather.ui.navigation.TopBar
import com.example.weather.ui.theme.Blue
import com.example.weather.ui.theme.DarkBlue
import com.example.weather.ui.theme.LightBlue
import com.example.weather.ui.theme.WeatherTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //TODO change status bar color
            WeatherApp()
            isLocationPermissionGranted()
        }
    }

    private fun isLocationPermissionGranted(): Boolean {
        return if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION),
                0
            )
            false
        } else {
            true
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
}
