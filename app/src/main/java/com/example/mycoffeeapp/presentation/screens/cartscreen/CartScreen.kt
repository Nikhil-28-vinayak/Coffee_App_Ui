package com.example.mycoffeeapp.presentation.screens.cartscreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.domain.model.Product

@Preview
@Composable
fun CartScreen(){
    val product = listOf(
        Product(
            id = 1,
            name = "Espresso",
            description = "Strong and rich",
            price = 3.80,
            imageResource = R.drawable.coffee_1
        ), Product(
            id = 2,
            name = "Latte",
            description = "Smooth and creamy",
            price = 2.80,
            imageResource = R.drawable.coffee_2
        ), Product(
            id = 3,
            name = "Cappuccinos",
            description = "With chocolate",
            price = 1.40,
            imageResource = R.drawable.coffee_3
        )
    )
}