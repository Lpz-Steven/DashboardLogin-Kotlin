package com.example.proyectodashboard4.components

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Alarm
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.proyectodashboard4.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// Funcion para disenar el navegador inferior y se utiliza navController
// para que se pueda navegar entre varias secciones de la aplicacion
@Composable
//La función BottomMenu es una función de Compose que crea un menú de navegación
// en la parte inferior de la pantalla. Toma como parámetros un NavHostController
// y una lista de objetos Items_bar, donde cada objeto representa un elemento del
// menú de navegación.
fun BottomMenu(
    navController: NavHostController,
    menu_items_bar: List<Items_bar>
) {
    //Dentro de la función, se utiliza un BottomAppBar para crear la barra inferior del menú de
    // navegación. Se le aplica un cutoutShape para que tenga esquinas redondeadas y un efecto
    // de corte en el centro. El color de fondo de la barra se toma de MaterialTheme.colors.primary.
    BottomAppBar (cutoutShape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50)), backgroundColor = MaterialTheme.colors.primary,) {
        //Dentro del BottomAppBar, se utiliza un BottomNavigation para mostrar los
        // ítems del menú de navegación. Se le aplica un Modifier.padding para
        // ajustar el espaciado en la parte inferior de la barra
        BottomNavigation(
            modifier = Modifier.padding(
                0.dp,
                0.dp,
                60.dp,
                0.dp
            ),backgroundColor = MaterialTheme.colors.primary,
        )  {
            val currentRouteBar = Current_Route(navController = navController)
            menu_items_bar.forEach {
                item ->
                BottomNavigationItem(selected = currentRouteBar == item.ruta, onClick = { navController.navigate(item.ruta)},
                icon = {
                    Icon(painter = painterResource(id = item.icon), contentDescription = item.title, modifier = Modifier.size(30.dp))
                },
                label = { Text(text = item.title)})
            }
        }


    }
}
// Funcion para disenar el boton flotante, al hacerle click muestra un mensaje
@Composable
fun Fab(
    //La función Fab es una función de Compose que crea un botón flotante.
    // Toma como parámetros un CoroutineScope y un ScaffoldState.
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
) {
    val idNotification: Int = 0
    val context: Context = LocalContext.current
    val idChannel: String = "CanalTienda"
    val name = "CanalTienda"
    val descriptionText = "Canal de Notificaciones"

    val textShort: String = "Ejemplo de notificacion sencilla con prioridad por omision (default)"
    val textLong: String = "Saludos! Esta es una prueba de notificaciones. Debe aparecer "+
            "un icono a la derecha y el texto puede tener una longitud de 200 caracteres. "+
            "El tamaño de la notificacion puede colapsar y/o expandirse." +
            "Gracias y hasta pronto"
    val iconoBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.correo
    )
    val imagenBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.bg_tienda_cba
    )

    LaunchedEffect(Unit){
        CreateChannelNotification(
            idChannel,
            context,
            name,
            descriptionText
        )
    }
    //Se define el contenido del botón flotante (FloatingActionButton).
    // Al hacer clic en el botón, se muestra una notificación de tipo
    // Snackbar (un mensaje temporal en la parte inferior de la pantalla)
    // utilizando el scaffoldState.snackbarHostState.
    FloatingActionButton(onClick = {
        scope.launch { scaffoldState.snackbarHostState
            .showSnackbar(
                "Compras",
                actionLabel = "Aceptar",
                duration = SnackbarDuration.Indefinite
            )}
        notificacionProgramada(
            context
        )
    },
    backgroundColor = MaterialTheme.colors.primaryVariant) {
        Icon(imageVector = Icons.Outlined.ShoppingCart,
            contentDescription = "Recompensas")
    }
}