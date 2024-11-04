package com.example.appproductos.Navigation

sealed class NavDestinations(val route: String) {
    object Home : NavDestinations("home")
    object ListView : NavDestinations("listView")
    object Formulario : NavDestinations("formulario")
    object PresentationView : NavDestinations("presentationView")
}