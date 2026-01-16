package com.example.mycoffeeapp.presentation.screens.homescreen


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.domain.model.Product
import kotlinx.coroutines.CoroutineScope


@Composable
fun ProductGrid(
    navController: NavHostController,
    scope: CoroutineScope,
    snackbarState: SnackbarHostState,
    topContent: @Composable () -> Unit,
    showCategory: String
) {

    val product = listOf(
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
        ),
        Product(
            id = 4,
            name = "Mocha",
            description = "With cocoa flavor",
            price = 3.15,
            imageResource = R.drawable.coffee_4
        ),
        Product(
            id = 5,
            name = "Macchiato",
            description = "Bold and milky",
            price = 2.10,
            imageResource = R.drawable.coffee_5
        ),
        Product(
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

    val macchiato = listOf(
        Product(
            id = 1,
            name = "Macchiato",
            description = "Strong and rich",
            price = 4.6,
            imageResource = R.drawable.coffee_5
        ),
        Product(
            id = 2,
            name = "Cream Macchiato",
            description = "Strong and rich",
            price = 4.6,
            imageResource = R.drawable.img_1
        ),
        Product(
            id = 3,
            name = "Hot Macchiato",
            description = "Strong and rich",
            price = 4.6,
            imageResource = R.drawable.img_3
        ),
        Product(
            id = 4,
            name = "Iced Macchiato",
            description = "Strong and rich",
            price = 4.6,
            imageResource = R.drawable.img_4
        ),
        Product(
            id = 5,
            name = "Chocolatey Macchiato",
            description = "Strong and rich",
            price = 4.6,
            imageResource = R.drawable.img_5
        ),
        Product(
            id = 6,
            name = "Spacial Macchiato",
            description = "Strong and rich",
            price = 4.6,
            imageResource = R.drawable.img_6
        ),
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
    ) {
        item {
            topContent()
        }
        if (showCategory == "Macchiato") {
            items(macchiato.chunked(2)) { rowItem ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    ProductCard(
                        rowItem[0],
                        Modifier.weight(1f),
                        navController,
                        scope,
                        snackbarState
                    )
                    if (rowItem.size == 2) {
                        ProductCard(
                            rowItem[1],
                            Modifier.weight(1f),
                            navController,
                            scope,
                            snackbarState
                        )
                    }
                }
            }
        } else {
            items(product.chunked(2)) { rowItem ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    ProductCard(
                        rowItem[0],
                        Modifier.weight(1f),
                        navController,
                        scope,
                        snackbarState
                    )
                    if (rowItem.size == 2) {
                        ProductCard(
                            rowItem[1],
                            Modifier.weight(1f),
                            navController,
                            scope,
                            snackbarState
                        )
                    }
                }
            }
        }
    }
}
