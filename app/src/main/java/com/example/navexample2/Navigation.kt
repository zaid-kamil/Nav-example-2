package com.example.navexample2

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navexample2.ui.DetailUI
import com.example.navexample2.ui.HomeUI
import com.example.navexample2.ui.WelcomeUI

sealed class Screen(val route: String) {
    object WelcomeScreen : Screen("welcome_screen")
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen")

    fun withArgs(vararg args: String): String {
        val path = buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
        Log.d("Navigation", "path: $path")
        return path
    }
}

@Composable
fun Nav(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = Screen.WelcomeScreen.route
    ) {
        composable(Screen.WelcomeScreen.route) {
            WelcomeUI(navController)
        }
        composable(
            Screen.HomeScreen.route + "/{username}",
            arguments = listOf(
                navArgument("username") { type = NavType.StringType }
            )
        ) {
            val username = it.arguments?.getString("username")
            HomeUI(navController, username)
        }
        composable(
            Screen.DetailScreen.route + "/{index}",
            arguments = listOf(navArgument("index") { type = NavType.StringType })
        ) {
            val index = it.arguments?.getString("index")
            DetailUI(navController, index)
        }
    }
}







