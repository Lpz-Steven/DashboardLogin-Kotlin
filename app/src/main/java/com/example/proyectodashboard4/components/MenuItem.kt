package com.example.proyectodashboard4.components

import com.example.proyectodashboard4.R

// import:
//El código importa el recurso de identificador de recursos (R) que contiene las
// referencias a los recursos de la aplicación, como imágenes, diseños, etc.
//
//Clase sellada (sealed class) MenuItem:
//Una clase sellada es una clase que se utiliza para representar una jerarquía de
// objetos en la que todos los subtipos posibles están definidos dentro de la
// propia clase. Los subtipos son objetos internos de la clase sellada,
// y no se pueden heredar o crear objetos de la clase sellada directamente fuera de ella.

sealed class MenuItem (
    val icon: Int,
    val title: String,
    val ruta: String
        ) {
    object  Page01: MenuItem(R.drawable.bg_tienda_cba, "Principal", "page01")
    object  Page02: MenuItem(R.drawable.ic_flores, "Animals", "page02")
    object  Page03: MenuItem(R.drawable.ic_frutas_verduras, "Frutas y Verduras", "page03")
    object  Page04: MenuItem(R.drawable.ic_huevos, "Huevos", "page04")
    object  Page05: MenuItem(R.drawable.ic_lacteos, "Lacteos", "page05")
    object  Page06: MenuItem(R.drawable.ic_ver_mas, "Salir", "page06")
}
