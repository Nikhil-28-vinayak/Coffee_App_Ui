package com.example.mycoffeeapp.presentation.screens.homescreen


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mycoffeeapp.domain.model.Product


@Composable
fun ProductGrid(
    product: List<Product>,
    navController: NavHostController,
    topContent: @Composable () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
    ) {
        item{
           topContent()
        }
        items(product.chunked(2)){rowItem->
            Row(modifier = Modifier.fillMaxWidth()) {
                ProductCard(rowItem[0], Modifier.weight(1f), navController)
                if (rowItem.size==2){
                    ProductCard(
                        rowItem[1],
                        Modifier.weight(1f),
                        navController
                    )
                }
            }
        }
    }
}
