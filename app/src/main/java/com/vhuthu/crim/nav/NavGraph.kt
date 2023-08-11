package com.vhuthu.crim.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = Screens.Mainscreen.route ){

        composable(Screens.Mainscreen.route){
//            Screens.Mainscreen()
        }
    }
}