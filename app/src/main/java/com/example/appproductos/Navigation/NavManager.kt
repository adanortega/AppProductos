package com.example.appproductos.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appos.Views.PresentationViewScreen
import com.example.appproductos.Views.FormularioViewScreen
import com.example.appproductos.Views.HomeViewScreen
import com.example.appproductos.Views.ListViewScreen

@Composable
fun NavManager(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavDestinations.Home.route) {
        composable(NavDestinations.Home.route) {
            HomeViewScreen(navController = navController)  // Navegación hacia HomeViewScreen
        }
        composable(NavDestinations.ListView.route) {
            ListViewScreen(navController = navController)  // Navegación hacia ListViewScreen
        }
        composable(NavDestinations.Formulario.route) {
            FormularioViewScreen(navController = navController)  // Navegación hacia FormularioViewScreen
        }
        composable(NavDestinations.PresentationView.route) {
            PresentationViewScreen(navController = navController)  // Navegación hacia PresentationViewScreen
        }
    }
}
