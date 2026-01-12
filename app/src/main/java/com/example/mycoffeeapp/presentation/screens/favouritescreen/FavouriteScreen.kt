package com.example.mycoffeeapp.presentation.screens.favouritescreen


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.domain.model.Product
import com.example.mycoffeeapp.presentation.ui_Components.MyBottomNavBar

@Composable
fun FavouriteScreen(navController: NavHostController) {
    var favouriteItem by remember {
        mutableStateOf(
            listOf(
                Product(
                    id = 1,
                    name = "Espresso",
                    description = "Strong and rich",
                    price = 3.80,
                    imageResource = R.drawable.coffee_1
                ),
                Product(
                    id = 2,
                    name = "Latte",
                    description = "Smooth and creamy",
                    price = 2.80,
                    imageResource = R.drawable.coffee_2
                ),
                Product(
                    id = 3,
                    name = "Cappuccinos",
                    description = "With chocolate",
                    price = 1.40,
                    imageResource = R.drawable.coffee_3
                )
            )
        )
    }

    Scaffold(
        topBar = { FavouriteScreenTopAppBar() },
        bottomBar = { MyBottomNavBar(navController,"Favourite") }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {

            item {
                favouriteItem.forEach() { product ->
                    FavouriteItemCart(product) {
                        favouriteItem = favouriteItem - product
                    }
                }
            }
        }
    }

}
