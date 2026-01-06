package com.example.logincomposeform

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation()
{
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "image"
    ) {

        composable("image") {
            ImageView(
                onNextClick = {
                    navController.navigate("alert")
                }
            )
        }

        composable("alert") {
            Alertdialog(
                onNavigateClick = {
                    navController.navigate("Circular Button")
                }
            )
        }

        composable("Circular Button")
        {
            CircularButton(
                onCircularButton = {
                    navController.navigate("ConstraintScreenPage")
                }
            )
        }
        composable("ConstraintScreenPage")
        {
            Constraint(
                onConstarint = {
                    navController.navigate("Scaffold")
                }
            )
        }
        composable("Scaffold")
        {
            ScaffoldScreen()
        }
    }
}