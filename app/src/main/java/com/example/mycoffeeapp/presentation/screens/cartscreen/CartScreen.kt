package com.example.mycoffeeapp.presentation.screens.cartscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.domain.model.Product
import com.example.mycoffeeapp.presentation.theme.LightBrown
import com.example.mycoffeeapp.presentation.ui_Components.MyBottomNavBar


@Composable
fun CartScreen(navController: NavHostController) {

    val cartProduct = listOf(
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
    var price by remember { mutableStateOf(12.50) }
    var deliveryFee by remember { mutableStateOf(1.0) }
    val totalAmount by remember { mutableStateOf(price + deliveryFee) }

    Scaffold(
        topBar = { CartScreenTopAppBar(navController) },
        bottomBar = { MyBottomNavBar(navController) }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            item {
                Row {
                    Text(
                        "Deliver",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = LightBrown
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            items(cartProduct) { item ->
                CartItemCart(item)
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "Payment Summary",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text("Price", fontSize = 18.sp)
                    Text("$ $price", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(2.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text("Delivery Fee", fontSize = 18.sp)
                    Text("$ $deliveryFee", fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(16.dp))

                PaymentModeSelectionCard(totalAmount)
            }
        }
    }
}