package com.example.mycoffeeapp.presentation.screens.homescreen

import androidx.compose.runtime.Composable
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.domain.model.Product

@Composable
fun Macchiato(){
    val macchiato = listOf(
        Product(id = 1, name = "Macchiato", description = "Strong and rich", price = 4.6, imageResource = R.drawable.coffee_5),
        Product(id = 2, name = "Cream Macchiato", description = "Strong and rich", price = 4.6, imageResource = R.drawable.img_1),
        Product(id = 3, name = "Hot Macchiato", description = "Strong and rich", price = 4.6, imageResource = R.drawable.img_3),
        Product(id = 4, name = "Iced Macchiato", description = "Strong and rich", price = 4.6, imageResource = R.drawable.img_4),
        Product(id = 5, name = "Chocolatey Macchiato", description = "Strong and rich", price = 4.6, imageResource = R.drawable.img_5),
        Product(id = 6, name = "Spacial Macchiato", description = "Strong and rich", price = 4.6, imageResource = R.drawable.img_6),
    )
}