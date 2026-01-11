package com.example.mycoffeeapp.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {

    @Serializable
    object WelcomeScreen : Routes()

    @Serializable
    object HomeScreen : Routes()

    @Serializable
    data class DetailScreen(val productId: Int) : Routes()

    @Serializable
    object CartScreen:Routes()

    @Serializable
    object  FavouriteScreen:Routes()

    @Serializable
    object ProfileScreen:Routes()
}
