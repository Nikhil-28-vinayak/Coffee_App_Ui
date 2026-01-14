package com.example.mycoffeeapp.presentation.screens.detailscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.presentation.navigation.Routes
import com.example.mycoffeeapp.presentation.theme.LightBrown

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenTopAppBar(navController: NavHostController) {
    var changeColor by remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            Text(
                "Details",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        },
        actions = {
            IconButton(onClick = { if (!changeColor) changeColor = true else changeColor = false},
                modifier = Modifier.size(50.dp)) {
                if (!changeColor) {
                    Icon(
                        painter = painterResource(R.drawable.regular_outline_heart),
                        contentDescription = "Add to favourite",
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .size(40.dp)
                    )
                } else {
                    Icon(
                        painter = painterResource(R.drawable.img_7),
                        contentDescription = "Add to favourite",
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .size(30.dp),
                        tint = LightBrown,
                    )
                }
            }
        },

        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.regular_outline_arrow_left),
                contentDescription = "Back Button",
                modifier = Modifier
                    .padding(start = 12.dp)
                    .clickable { navController.navigate(Routes.HomeScreen) }
            )
        }
    )
}
