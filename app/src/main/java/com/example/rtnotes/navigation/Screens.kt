package com.example.rtnotes.navigation

sealed class Screens(val route : String){

    data object HomeScreen : Screens("homeScreen")
    data object NoteScreen : Screens("noteScreen")

}
