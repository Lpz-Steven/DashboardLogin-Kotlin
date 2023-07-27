package com.example.proyectodashboard4.components

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectodashboard4.pages.splash.SplashScreen
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.proyectodashboard4.R
import com.example.proyectodashboard4.pages.Page_Contenidos
import com.example.proyectodashboard4.pages.Page_Flores
import com.example.proyectodashboard4.pages.Page_Frutas_Verduras
import com.example.proyectodashboard4.pages.Page_Huevos
import com.example.proyectodashboard4.pages.Page_Informacion
import com.example.proyectodashboard4.pages.Page_Inicio
import com.example.proyectodashboard4.pages.Page_Lacteos
import com.example.proyectodashboard4.pages.Page_Principal
import com.example.proyectodashboard4.pages.Page_Ver_Mas
import com.example.proyectodashboard4.pages.login.LoginScreen


//Clase PagesScreen (enum):
//Esta es una enumeración que define diferentes pantallas de la aplicación
// con su icono y título asociado. Cada elemento de la enumeración
// representa una pantalla y contiene información sobre cómo debe
// ser mostrada en la interfaz.

enum class PagesScreen(
    val icon: Int,
    val title: String,
){
    Start(R.drawable.sena, title = "Splash"),
    Login(R.drawable.sena, title = "Login"),
    Tienda(R.drawable.sena, title = "Splash"),
    Principal(R.drawable.bg_tienda_cba, title = "Principal"),
    Flores(R.drawable.ic_flores, title = "Animales"),
    Huevos(R.drawable.ic_huevos, title = "Huevos"),
    FruVer(R.drawable.ic_frutas_verduras, title = "Frutas y Verduras"),
    Leche(R.drawable.ic_lacteos, title = "Lacteos"),
    VerMas(R.drawable.ic_ver_mas, title = "Cerrar sesion"),


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Función TiendaAppBar:
//Esta función define el AppBar (barra de aplicación) que se muestra en la
// parte superior de la interfaz de la aplicación. Puede incluir un botón
// de navegación hacia atrás (ArrowBack) si la pantalla actual permite volver
// a una pantalla anterior. La barra tiene un título ("Proyecto_Login") y un color
// de fondo verde.

fun TiendaAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier

){
    TopAppBar(
        title = { Text("Proyecto_Login", style = MaterialTheme.typography.titleLarge, color = Color.White) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = colorResource(id = R.color.greenSena)
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        }
    )
}
//Funcion que contiene las navegaciones en un scaffold
@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Función TiendaApp:
//Esta es la función principal que muestra la interfaz de la aplicación
// de la tienda. Utiliza un Scaffold de Compose, que es una implementación
// de la estructura básica de una pantalla en Compose que incluye AppBar,
// Drawer (menú lateral), BottomBar (barra inferior) y otras áreas para
// colocar contenido. Dentro de esta función, se definen los elementos de
// navegación y los componentes que se mostrarán en cada pantalla.

fun TiendaApp(
    navController: NavHostController = rememberNavController()
){
    val navigationItemsBottomBar = listOf(
        Items_bar.Boton1,
        Items_bar.Boton2,
        Items_bar.Boton3
    )
    val navigationItems = listOf(
        PagesScreen.Principal,
        PagesScreen.FruVer,
        PagesScreen.Huevos,
        PagesScreen.Leche,
        PagesScreen.Flores,
        PagesScreen.VerMas
    )
    val scaffoldState = rememberScaffoldState()
    // scope: utilizada para abrir/cerrar el menu lateral
    val scope = rememberCoroutineScope()
    var index by rememberSaveable {
        mutableStateOf(false)
    }
    val videoUri = "android.resource://com.example.proyectodashboard4/raw/clouds"
    Uri.parse(videoUri)
    val navController = rememberNavController()


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            if(index){
                TopBar(
                    scope,
                    scaffoldState,
                    navController,
                    navigationItems
                )
            }
            else{}

        },
        drawerContent = {
            DrawerMenu(
                scope,
                scaffoldState,
                navController,
                menu_items = navigationItems
            )
        },
        bottomBar = {
            if(index){
                BottomMenu(
                    navController,
                    menu_items_bar = navigationItemsBottomBar
                )
            }
            else{}

        },
        floatingActionButton = {
            if(index){
                Fab(
                    scope,
                    scaffoldState
                )
            }
            else{}

        },
        isFloatingActionButtonDocked = true
    )
    {
            padding ->
        //Composable ScaffoldContent:
        //Esta función define el contenido principal que se muestra en la
        // pantalla de la aplicación. En este caso, es una columna vacía

        ScaffoldContent(
            padding = padding
        )
        //NavHost y rutas de navegación:
        //La función NavHost se utiliza para definir la navegación entre las
        // diferentes pantallas de la aplicación. Se especifica un startDestination
        // que es la pantalla inicial que se mostrará. Luego, se definen las rutas
        // de navegación para cada pantalla a través de la función composable.

        NavHost(navController = navController, startDestination = PagesScreen.Start.name){
            composable(route = PagesScreen.Start.name){
                SplashScreen(navController, state = false)
            }
            composable(route = PagesScreen.Login.name){
                index = false
                LoginScreen(navController, state = index)
            }
            composable(PagesScreen.Principal.name){
                index = true
                Page_Principal(state = index)
            }
            composable(PagesScreen.Flores.name){
                Page_Flores()
            }
            composable(PagesScreen.FruVer.name){
                Page_Frutas_Verduras()
            }
            composable(PagesScreen.Huevos.name){
                Page_Huevos()
            }
            composable(PagesScreen.Leche.name){
                Page_Lacteos()
            }
            composable(PagesScreen.VerMas.name){
                Page_Ver_Mas()
            }
            composable(Items_bar.Boton1.ruta){
                Page_Inicio()
            }
            composable(Items_bar.Boton2.ruta){
                Page_Contenidos()
            }
            composable(Items_bar.Boton3.ruta){
                Page_Informacion()
            }
        }


    }

}
//muestra el contenido el contenido
@Composable
fun ScaffoldContent(
    padding: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(
                top = 16.dp,
                bottom = padding.calculateBottomPadding()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {

        }
    }
}