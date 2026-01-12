package com.example.mycoffeeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.mycoffeeapp.presentation.screens.cartscreen.CartScreen
import com.example.mycoffeeapp.presentation.screens.detailscreen.DetailScreen
import com.example.mycoffeeapp.presentation.screens.favouritescreen.FavouriteScreen
import com.example.mycoffeeapp.presentation.screens.homescreen.HomeScreen
import com.example.mycoffeeapp.presentation.screens.welcomescreen.WelcomeScreen

@Composable
fun Navgraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.WelcomeScreen){

        composable<Routes.WelcomeScreen> {
            WelcomeScreen(navController)
        }

        composable<Routes.HomeScreen> {
            HomeScreen(navController)
        }

        composable<Routes.DetailScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<Routes.DetailScreen>()
            DetailScreen(args,navController)
        }

        composable<Routes.CartScreen> {
            CartScreen(navController)
        }

        composable<Routes.FavouriteScreen> {
            FavouriteScreen(navController)
        }
    }
}