package com.ezecalc.loteriamexicana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.ezecalc.loteriamexicana.ui.theme.LoteriaMexicanaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoteriaMexicanaTheme {
                val navController = rememberNavController()
                Navigation(navController)
            }
        }
    }
}