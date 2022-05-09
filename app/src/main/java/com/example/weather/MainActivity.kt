package com.example.weather

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.weather.ui.navigation.NavDrawerItem
import com.example.weather.ui.navigation.NavHost
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

@Composable
fun TopBar(scope: CoroutineScope, scaffoldState: ScaffoldState) {

    TopAppBar(
        title = {
            Text("Weather")
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = null,
                )
            }
        }
    )
}

@Composable
fun Drawer(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavHostController
) {
    val items = listOf(
        NavDrawerItem.Overview,
        NavDrawerItem.ChangeLocation,
        NavDrawerItem.Settings
    )

    Column(
    ) {
        // Header
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_cloud_24),
            contentDescription = null,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .padding(10.dp)
        )

        // Space between
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(5.dp)
        )

        // List of navigation items
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            DrawerItem(
                item = item,
                selected = currentRoute == item.route,
                onItemClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            scope.launch {
                scaffoldState.drawerState.close()
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(modifier = Modifier
            .padding(12.dp)
            .align(Alignment.CenterHorizontally),
            text = "Developed by Vumba798",
            color = Color.DarkGray
        )
    }
}

@Composable
fun DrawerItem(
    item: NavDrawerItem,
    selected: Boolean,
    onItemClick: (NavDrawerItem) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onItemClick(item) })
            .height(45.dp)
            .background(Blue)
            .padding(start = 10.dp)
    ) {
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.DarkGray),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(35.dp)
                .width(35.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = item.title,
            fontSize = 18.sp,
        )
    }
}
