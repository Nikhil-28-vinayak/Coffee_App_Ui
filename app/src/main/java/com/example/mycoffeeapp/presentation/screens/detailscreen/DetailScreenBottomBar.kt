package com.example.mycoffeeapp.presentation.screens.detailscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycoffeeapp.presentation.theme.IvaryWhite
import com.example.mycoffeeapp.presentation.theme.LightBrown
import com.example.mycoffeeapp.presentation.ui_Components.AppMessageDialog

@Composable
fun DetailScreenBottomBar() {
    var showCartDialog by remember { mutableStateOf(false) }
    BottomAppBar(
        containerColor = Color.Transparent
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Price", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text("$4.53", fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
            }

            Spacer(modifier = Modifier.width(40.dp))

            Button(
                onClick = {showCartDialog = true},
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBrown,
                    contentColor = IvaryWhite
                )
            ) {

                Text(
                    "Add to cart", fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            AppMessageDialog(
                show = showCartDialog,
                title = "Added to Cart",
                message = "Item has been added to your cart.",
                onDismiss = {showCartDialog = false}
            )
        }
    }
}