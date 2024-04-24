package com.evangelista.composedestination

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ramcosta.composedestinations.DestinationsNavHost
import com.simangcaj.composedestination.ui.theme.ComposeDestinationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDestinationTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}






