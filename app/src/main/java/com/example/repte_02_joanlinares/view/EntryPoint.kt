package com.example.repte_02_joanlinares.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.repte_02_joanlinares.Routes


@Composable
fun EntryPoint(navigationController: NavController) {
    NavHost(
        navController = navigationController as NavHostController,
        startDestination = Routes.Screen1.route
    ) {
        composable(Routes.Screen1.route) { LaunchScreen(navigationController) }
        composable(Routes.Screen2.route) { TriaPersonatgeScreen(navigationController) }
        composable(
            route = Routes.Screen3.route,
            arguments = listOf(navArgument("imageId") { type = NavType.IntType })
        ) { backStackEntry ->
            val imageId = backStackEntry.arguments?.getInt("imageId") ?: -1
            TriaNomScreen(navigationController, imageId)
        }
        composable(
            route = Routes.Screen4.route,
            arguments = listOf(
                navArgument("imageId") { type = NavType.IntType },
                navArgument("nom") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val imageId = backStackEntry.arguments?.getInt("imageId") ?: -1
            val nom = backStackEntry.arguments?.getString("nom") ?: ""
            ResultatScreen(navigationController, imageId, nom)
        }

    }
}