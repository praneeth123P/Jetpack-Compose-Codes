package com.example.logincomposeform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.logincomposeform.data.network.ConstantClasses
import com.example.logincomposeform.ui.theme.LoginComposeFormTheme

class HomeActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginComposeFormTheme(dynamicColor = false, darkTheme = false)
            {
                val navController = rememberNavController()
                Surface(color = Color.White) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(navController = navController)
                        }, content = { padding ->
                            // Nav host: where screens are placed
                            NavHostContainer(navController = navController, padding = padding)
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(paddingValues = padding),

        builder = {

            composable("home") {
                HomeScreen()
            }

            composable("search") {
                SearchScreen()
            }

            composable("account") {
                AccountBox()
            }
        })
}

@Composable
fun BottomNavigationBar(navController: NavHostController)
{
        NavigationBar(
            containerColor = Color(0xFF0F9D58)) {
            val navBack by navController.currentBackStackEntryAsState()
            val currentRoute = navBack?.destination?.route
            ConstantClasses.BottomClass.forEach { navItem ->

                NavigationBarItem(

                    selected = currentRoute == navItem.route,
                    onClick = {
                        navController.navigate(navItem.route)
                    },

                    icon = {
                        Icon(imageVector = navItem.icon, contentDescription = navItem.label)
                    },

                    label = {
                        Text(text = navItem.label)
                    },

                    alwaysShowLabel = false,

                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.White,
                        unselectedIconColor = Color.White,
                        selectedTextColor = Color.White,
                        indicatorColor = Color(0xFF195334)
                    )
                )
            }
        }
}
