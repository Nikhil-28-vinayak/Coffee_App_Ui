package com.example.mycoffeeapp.presentation.screens.detailscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.domain.model.Product
import com.example.mycoffeeapp.presentation.theme.IvaryWhite
import com.example.mycoffeeapp.presentation.theme.LightBrown
import com.example.mycoffeeapp.presentation.theme.LightGray

@Composable
fun ProductDetailContent(product: Product, innerPadding: PaddingValues) {

    var selectedTextSize by remember { mutableStateOf("M") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(innerPadding)
    ) {
        Image(
            painter = painterResource(product.imageResource),
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(
                    RoundedCornerShape(16.dp)
                ),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            product.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                "Ice/Hot",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )
            Icon(
                painter = painterResource(R.drawable.default_bean),
                contentDescription = "bean",
                tint = LightBrown,
                modifier = Modifier
                    .background(
                        color = IvaryWhite,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .size(36.dp)
                    .padding(6.dp)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))

        HorizontalDivider(color = Color.LightGray.copy(alpha = 0.5f))

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            "Description",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            product.description,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            "Size",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {

            listOf("S", "M", "L").forEach() { size ->
                SelectSizeChip(
                    sizeText = size,
                    selected = selectedTextSize == size,
                    onClick = { selectedTextSize = size },
                    modifier = Modifier
                        .weight(1F)
                        .height(46.dp)
                )
            }
        }
    }
}