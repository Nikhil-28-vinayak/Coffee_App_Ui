package com.example.mycoffeeapp.presentation.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.domain.model.Product
import com.example.mycoffeeapp.presentation.ui_Components.MyBottomNavBar

@Composable
fun HomeScreen(navController: NavHostController) {
    var showLocation by remember { mutableStateOf(false) }
    val snackbarState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val location1 = "Janatha Rd, Palarivattom"
    val location2 = "Ernakulam, Kerala - 682025"

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarState) },
        bottomBar = { MyBottomNavBar(navController, "Home") }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f / 3f)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF303030), Color(0XFF1F1F1F), Color(0XFF121212))
                    )
                )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)
        ) {

            // Display Product

            var showCategories by remember { mutableStateOf("") }
            ProductGrid(navController, scope, snackbarState, topContent = {

                Text("Location", color = Color.Gray, fontSize = 14.sp)

                Spacer(modifier = Modifier.height(4.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Text(
                        location1,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )

                    Icon(
                        imageVector = if (!showLocation) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = "Change location",
                        tint = Color.White,
                        modifier = Modifier.clickable {
                            if (!showLocation) showLocation = true else showLocation = false
                        }
                    )

                }
                if (showLocation) {
                    Text(
                        location2,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 13.sp
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))

                MySearchBar()

                Spacer(modifier = Modifier.height(40.dp))

                Image(painter = painterResource(R.drawable.banner_1), contentDescription = "banner")

                Spacer(modifier = Modifier.height(16.dp))

                showCategories=homeScreenCategories()

                Spacer(modifier = Modifier.height(16.dp))

            },
               showCategory = showCategories
            )
        }
    }
}
