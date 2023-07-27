package com.example.proyectodashboard4.components

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.example.proyectodashboard4.components.NotificacionProgramada.Companion.NOTIFICATION_ID
import java.util.Calendar

//fun notificacionProgramada(context: Context):
//Esta función se encarga de programar una notificación para que aparezca
// en un momento específico en el futuro.
//context: El contexto de la aplicación.

//Creación de Intent:
//Se crea un Intent que especifica la actividad (NotificacionProgramada)
// que se iniciará cuando se muestre la notificación programada.
// El intent también puede contener datos adicionales necesarios para la actividad.

//Creación de PendingIntent:
//Se crea un PendingIntent a partir del Intent anterior.
// El PendingIntent representa una intención que se ejecutará en el futuro.
// En este caso, se utilizará un BroadcastReceiver para mostrar la notificación programada.

//context: El contexto de la aplicación.
//NOTIFICATION_ID: Es una constante definida en la clase NotificacionProgramada.
// Companion que representa un ID único para la notificación programada.
// Probablemente, este valor es utilizado para identificar y actualizar la notificación en el futuro.

//Obtención del AlarmManager:
//Se obtiene una instancia del AlarmManager del sistema a través del servicio Context.ALARM_SERVICE.
// El AlarmManager permite programar eventos para ejecutarse en el futuro.

//Programación de la notificación:
//Se utiliza el AlarmManager para programar la notificación en un momento específico en el
// futuro utilizando el método setExact. En este caso, la notificación está programada
// para mostrarse 10 segundos después del momento actual.

//AlarmManager.RTC_WAKEUP: Especifica el tipo de alarma, en este caso, se usará el reloj en tiempo real y el dispositivo se despertará si está en modo de suspensión para mostrar la notificación.
//Calendar.getInstance().timeInMillis + 10000: Calcula el tiempo en milisegundos 10 segundos después del momento actual para mostrar la notificación.
//pendingIntent: El PendingIntent que se ejecutará cuando se dispare la alarma, lo que resultará en la presentación de la notificación programada.
//En resumen, esta función notificacionProgramada programa una notificación para que se muestre 10 segundos después de llamar a esta función. El contenido y el aspecto de la notificación en sí misma estarán definidos en la clase NotificacionProgramada.


fun notificacionProgramada(
    context: Context,
) {
    //Intent describe la actividad que se debe iniciar y contiene los datos necesarios para ello.
    val intent = Intent(
        context,
        NotificacionProgramada::class.java
    ).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    val pendingIntent: PendingIntent = PendingIntent.getBroadcast(
        context,
        NOTIFICATION_ID,
        intent,
        PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
    )
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    alarmManager.setExact(
        AlarmManager.RTC_WAKEUP,
        Calendar.getInstance().timeInMillis + 10000,
        pendingIntent
    )
}