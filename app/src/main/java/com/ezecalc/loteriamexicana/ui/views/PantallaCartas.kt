package com.ezecalc.loteriamexicana.ui.views

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

/*
* Para obtener las cartas desde res/drawable, las enumeré del 1 al 54
* y la nomenclatura es cartai
* */
fun obtenerListaCartas(context: Context): List<Int> {
    val cartas = mutableListOf<Int>()
    for (i in 1..54) {
        val nombreCarta = "carta$i"
        val resourceId = context.resources.getIdentifier(nombreCarta, "drawable", context.packageName)
        if (resourceId != 0) {
            cartas.add(resourceId)
        }
    }
    return cartas
}

@Composable
fun PantallaCartas(navController: NavController) {
    val context = LocalContext.current
    val listaCartas = obtenerListaCartas(context)

    var cartasLoteria = remember { listaCartas.toMutableList() }
    var cartaActual by remember { mutableStateOf<Int?>(null) }

    fun obtenerNuevaCarta() {
        if (cartasLoteria.isNotEmpty()) { //Para ver si aún quedan cartas
            cartaActual = cartasLoteria.random().also { cartasLoteria.remove(it) } //Definir carta actual
        } else {
            cartaActual = null // Esto para que no haya cartas actuales
        }
    }
    LaunchedEffect(Unit) {
        obtenerNuevaCarta()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        cartaActual?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = "Carta de la Lotería",
                modifier = Modifier.size(300.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { obtenerNuevaCarta() },
            enabled = cartasLoteria.isNotEmpty()
        ) {
            Text(text = "Nueva Carta")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Terminar Juego")
        }
    }
}