package com.example.proyectodashboard4.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.proyectodashboard4.pages.Page_Contenidos
import com.example.proyectodashboard4.pages.Page_Flores
import com.example.proyectodashboard4.pages.Page_Frutas_Verduras
import com.example.proyectodashboard4.pages.Page_Huevos
import com.example.proyectodashboard4.pages.Page_Informacion
import com.example.proyectodashboard4.pages.Page_Inicio
import com.example.proyectodashboard4.pages.Page_Lacteos
import com.example.proyectodashboard4.pages.Page_Principal
import com.example.proyectodashboard4.pages.Page_Ver_Mas
import com.example.proyectodashboard4.components.Items_bar
import com.example.proyectodashboard4.components.MenuItem

//contiene una función de Compose llamada Current_Route que actúa como un
// controlador para obtener la ruta actual en una aplicación de navegación
// implementada con el componente NavHost de Android Jetpack Compose.
// El código también muestra algunas importaciones y definiciones de rutas
// para distintas pantallas de la aplicación.
@Composable
fun Current_Route(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}