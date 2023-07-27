package com.example.proyectodashboard4.pages

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectodashboard4.R
import com.example.proyectodashboard4.components.CreateChannelNotification
import com.example.proyectodashboard4.components.notificacionProgramada


@Composable
fun Page_Principal(state: Boolean) {
    val idNotification: Int = 0
    val context: Context = LocalContext.current
    val idchannel: String = stringResource(R.string.canal_Tienda)
    val name = stringResource(R.string.canal_Tienda)
    val descriptionText= stringResource(R.string.canal_Notifi)

    val textShort: String = "Ejemplo de notificación sencilla con prioridad de omisión (default)"
    val textLong: String = "Saludos! Esta es una prueba de notificaciones. Debe aparecer " +
            "un icono a la derecha y el texto puede tener una longitud de 200 caracteres. " +
            "El tamaño de la notificacion puede colapsar y/o expandirse " +
            "Gracias y hasta pronto"
    val iconoBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.ic_contact_mail_black_48dp
    )
    val imagenBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.bg_tienda_cba
    )

    LaunchedEffect(Unit){
        CreateChannelNotification(
            idchannel,
            context,
            name,
            descriptionText
        )
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),

        ) {
        Image(
            painter = painterResource(R.drawable.carrusel_1), // Reemplaza "carrusel_1" con el nombre de tu imagen en el directorio de recursos
            contentDescription = "Imagen Principal",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        // Boton
        IconButton(onClick = {
            notificacionProgramada(
                context
            )
        }) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Boton favorito"
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        androidx.compose.material3.Text(
            text = "Tienda CBA",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(0.dp))
        androidx.compose.material3.Text(
            text = "La tienda CBA (Campesinos de Baja Agricultura) del SENA es un espacio encantador ubicado en una zona rural, rodeado de exuberante vegetación y campos cultivados. Esta tienda es un proyecto apoyado por el Servicio Nacional de Aprendizaje (SENA) que tiene como objetivo promover y comercializar productos campesinos naturales y de alta calidad.\n" +
                    "\n" +
                    "Al ingresar a la tienda CBA, recibirás una cálida bienvenida con un aroma fresco que proviene de los productos agrícolas recién cosechados. El ambiente es acogedor y rústico, con estanterías de madera rústica y cestas de mimbre que exhiben una amplia variedad de alimentos y productos artesanales.\n" +
                    "\n" +
                    "En cada rincón de la tienda encontrará productos provenientes de pequeños agricultores y productores locales. Los estantes están llenos de frutas y verduras frescas de temporada, cultivadas sin el uso de pesticidas ni fertilizantes químicos. También encontrará miel orgánica, quesos artesanales, mermeladas caseras, huevos de gallina criadas en libertad y pan recién horneado con harina de trigo integral.\n" +
                    "\n" +
                    "La tienda CBA se enorgullece de su compromiso con la sostenibilidad y la promoción de la agricultura responsable. Además de los alimentos frescos, también ofrecemos una amplia selección de productos naturales y ecológicos, como productos de cuidado personal elaborados con ingredientes orgánicos y cosméticos naturales elaborados con extractos de plantas.",

            modifier = Modifier
                .width(800.dp)
                .padding(40.dp)
        )
    }
}