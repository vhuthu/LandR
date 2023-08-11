package com.vhuthu.crim.nav

sealed class Screens(val route : String){
    object Mainscreen : Screens(route = "main_screen")
    object Mainscreen2 : Screens(route = "main_screen_2")
}
