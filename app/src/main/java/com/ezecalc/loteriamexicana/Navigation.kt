package com.ezecalc.loteriamexicana

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.ezecalc.loteriamexicana.ui.views.PantallaCartas
import com.ezecalc.loteriamexicana.ui.views.PantallaInicio


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "pantallaInicio") {
        composable("pantallaInicio") {
            PantallaInicio(navController)
        }
        composable("pantallaCartas") {
            PantallaCartas(navController)
        }
    }
}