package com.escanillajd.composedestination

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraphNavigator
import androidx.navigation.compose.NavHost
import com.escanillajd.composedestination.screens.FirstScreen
import com.escanillajd.composedestination.screens.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route
import com.ramcosta.composedestinations.utils.composable


@Composable
fun MainScreen(

) {

        DestinationsNavHost(navGraph = NavGraphs.root)


}






