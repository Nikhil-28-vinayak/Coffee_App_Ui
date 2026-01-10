package com.example.mycoffeeapp.presentation.screens.detailscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.presentation.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenTopAppBar(navController: NavHostController) {

    TopAppBar(
        title = { Text("Detail",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        ) },
        actions = {
            Icon(
                painter = painterResource(R.drawable.regular_outline_heart),
                contentDescription = "Add to favourite",
                modifier = Modifier.padding(end = 12.dp).size(40.dp)
            )
        },
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.regular_outline_arrow_left),
                contentDescription = "Back Button",
                modifier = Modifier.padding(start = 12.dp).clickable { navController.navigate(Routes.HomeScreen) }
            )
        }
    )
}
