package com.example.mycoffeeapp.presentation.screens.detailscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.domain.model.Product

@Preview(showBackground = true)
@Composable
fun DetailScreen() {

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
        ), Product(
            id = 4,
            name = "Mocha",
            description = "With cocoa flavor",
            price = 3.15,
            imageResource = R.drawable.coffee_4
        ), Product(
            id = 5,
            name = "Maccthiato",
            description = "Bold and milky",
            price = 2.10,
            imageResource = R.drawable.coffee_5
        ), Product(
            id = 6,
            name = "Flat White",
            description = "Velvety smooth",
            price = 3.34,
            imageResource = R.drawable.coffee_6
        ),
        Product(
            id = 7,
            name = "Iced Mocha",
            description = "Refreshing and rich",
            price = 1.99,
            imageResource = R.drawable.coffee_3
        )
    )
    Scaffold(
        topBar = { DetailScreenTopAppBar() },
        bottomBar = { DetailScreenBottomBar() }
    ) {innerPadding->
        LazyColumn {
            item{
                //ProductDetailContent(innerPadding)
            }
        }

    }

}
