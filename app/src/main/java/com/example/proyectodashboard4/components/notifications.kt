package com.example.proyectodashboard4.components


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import android.Manifest
import com.example.proyectodashboard4.MainActivity
import com.example.proyectodashboard4.R

//CreateChannelNotification:
//Esta función crea un canal de notificación si el dispositivo está en Android 8.0
// (API nivel 26) o superior. Los canales de notificación se utilizan para agrupar
// y permiten al usuario controlar cómo se muestran las notificaciones de una aplicación.
// El canal recibe un ID, un contexto, un nombre y una descripción del canal.
//idChannel: El ID único del canal de notificación.
//context: El contexto de la aplicación.
//name: El nombre del canal de notificación.
//descriptionText: La descripción del canal de notificación.
fun CreateChannelNotification(
    idChannel: String,
    context: Context,
    name: String,
    descriptionText: String
) {
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

        val importance = NotificationManager.IMPORTANCE_DEFAULT
        //Definicion del Canal
        val channel = NotificationChannel(
            idChannel,
            name,
            importance
        ).apply {
            description = descriptionText
        }
        //Definicion del Gestor de Notificaciones

        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //Creacion del Canal
        notificationManager.createNotificationChannel(channel)

    }
}
//notificacionSencilla:
//Esta función muestra una notificación sencilla con texto y un icono. Al hacer clic en la notificación, abrirá la actividad principal (MainActivity) de la aplicación.
//context: El contexto de la aplicación.
//idChannel: El ID del canal de notificación al que pertenece la notificación.
//idNotification: Un ID único para la notificación.
//textTitle: El título de la notificación.
//textContent: El contenido del cuerpo de la notificación.
//priority: La prioridad de la notificación, por defecto es NotificationCompat.PRIORITY_DEFAULT.
fun notificacionSencilla(
    context: Context,
    idChannel: String,
    idNotification: Int,
    textTitle: String,
    textContent: String,
    priority: Int = NotificationCompat.PRIORITY_DEFAULT
) {
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
    val builder = NotificationCompat.Builder(
        context,
        idChannel
    )
        .setSmallIcon(R.drawable.login)
        .setContentTitle(textTitle)
        .setContentText(textContent)
        .setPriority(priority)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .build()

    with(NotificationManagerCompat.from(context)){
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        notify(idNotification, builder)
    }
}
//notificacionExtensa:
//Esta función muestra una notificación con un icono grande y un
// contenido extenso que se muestra expandiendo la notificación.
// También puede incluir una imagen grande (bigIcono) y texto adicional.
//context: El contexto de la aplicación.
//idChannel: El ID del canal de notificación al que pertenece la notificación.
//idNotification: Un ID único para la notificación.
//textTitle: El título de la notificación.
//textContent: El contenido del cuerpo de la notificación.
//bigIcono: Un Bitmap que representa el icono grande de la notificación.
//priority: La prioridad de la notificación, por defecto es NotificationCompat.PRIORITY_DEFAULT.
fun notificacionExtensa(
    context: Context,
    idChannel: String,
    idNotification: Int,
    textTitle: String,
    textContent: String,
    bigIcono: Bitmap,
    priority: Int = NotificationCompat.PRIORITY_DEFAULT
) {
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

    val builder = NotificationCompat.Builder(
        context,
        idChannel
    )
        .setSmallIcon(R.drawable.login)
        .setContentTitle(textTitle)
        .setContentText(textContent)
        .setLargeIcon(bigIcono)
        .setStyle(
            NotificationCompat.BigTextStyle()
                .bigText(textContent)
        )
        .setPriority(priority)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .build()

    with(NotificationManagerCompat.from(context)) {
        if(ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        notify(idNotification, builder)
    }
}
 //notificacionImagen:
       //Esta función muestra una notificación con una imagen grande adjunta que se muestra expandiendo la notificación. También puede incluir una imagen grande (bigIcono) y un título adicional para la notificación.
       //context: El contexto de la aplicación.
       //idChannel: El ID del canal de notificación al que pertenece la notificación.
       //idNotification: Un ID único para la notificación.
       //textTitle: El título de la notificación.
      // textContent: El contenido del cuerpo de la notificación.
       //bigIcono: Un Bitmap que representa el icono grande de la notificación.
      // bigImagen: Un Bitmap que representa la imagen grande que se mostrará en la notificación expandida.
       //priority: La prioridad de la notificación, por defecto es NotificationCompat.PRIORITY_DEFAULT.


fun notificacionImagen(
    context: Context,
    idChannel: String,
    idNotification: Int,
    textTitle: String,
    textContent: String,
    bigIcono: Bitmap,
    bigImagen: Bitmap,
    priority: Int = NotificationCompat.PRIORITY_DEFAULT
) {
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
    val builder = NotificationCompat.Builder(
        context,
        idChannel
    )
        .setSmallIcon(R.drawable.login)
        .setContentTitle(textTitle)
        .setContentText(textContent)
        .setLargeIcon(bigIcono)
        .setStyle(
            NotificationCompat
                .BigPictureStyle()
                .bigPicture(bigImagen)
                .setBigContentTitle("Tienda Sena CBA")
        )
        .setPriority(priority)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .build()

    with(NotificationManagerCompat.from(context)) {
        if(ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ){
            return
        }
        notify(idNotification, builder)
    }
}
