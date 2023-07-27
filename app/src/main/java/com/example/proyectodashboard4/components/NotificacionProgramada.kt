package com.example.proyectodashboard4.components

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.proyectodashboard4.MainActivity
import com.example.proyectodashboard4.R
import com.example.proyectodashboard4.utils.Constants.channelId

// El paquete com.example.proyectodashboard4.
// components es el paquete donde se encuentra definida la clase NotificacionProgramada.
//
//Se importan las clases necesarias para crear y mostrar la notificación,
// como NotificationManager, PendingIntent y NotificationCompat

class NotificacionProgramada: BroadcastReceiver() {

    companion object{
        const val NOTIFICATION_ID = 5
    }

    override fun onReceive(context: Context, intent: Intent?) {
        crearNotification(context)
    }
    //La función crearNotification es privada y se utiliza para configurar y mostrar la notificación.
    //Se crea un Intent que dirigirá al usuario a la actividad principal MainActivity
    // de la aplicación cuando se toque la notificación.
    //Se configura un PendingIntent utilizando el Intent creado anteriormente.
    // El PendingIntent se utilizará para abrir la actividad principal de la
    // aplicación cuando se toque la notificación.
    private fun crearNotification(context: Context) {

        val intent = Intent(
            context,
            MainActivity::class.java
        ).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val notificacion = NotificationCompat.Builder(
            context,
            channelId
        )
            .setSmallIcon(R.drawable.informacion)
            .setContentTitle("Tienda CBA")
            .setContentText("hola bienvenido a tienda sena")
            .setStyle(

                //La notificación también se configura con un estilo BigTextStyle
                // que permite mostrar un texto más largo cuando la notificación se expande.
                //Finalmente, se obtiene una instancia de NotificationManager del sistema y
                // se utiliza para mostrar la notificación con manager.notify(NOTIFICATION_ID, notificacion).

                NotificationCompat.BigTextStyle()
                    .bigText("Saludos! Tienda Sena esta abierta " +
                            "ahora puedes ver nuestros productos y novedades"+
                            "en nuestra aplicacion puedes verlo "

                    )
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE)
        as NotificationManager
        manager.notify(
            NOTIFICATION_ID,
            notificacion
        )


    }
}