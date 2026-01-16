package com.example.mycoffeeapp.presentation.screens.cartscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.presentation.theme.LightBrown
import com.example.mycoffeeapp.presentation.theme.LightGray


@Composable
fun PaymentModeSelectionCard(totalAmount: Double) {

    var changeIcon by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    var selectedMode by remember { mutableStateOf("Online") }
    val payModes = listOf("Online", "Cash")

    Card(
        modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(
            containerColor = LightGray,
        ), elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Column(modifier = Modifier.padding(24.dp)) {

            Row(verticalAlignment = Alignment.CenterVertically) {

                Icon(
                    painter = painterResource(if (selectedMode == "Online") R.drawable.mobile_banking else R.drawable.wallet),
                    contentDescription = "Payment Mode",
                    modifier = Modifier.size(30.dp),
                    tint = LightBrown
                )

                Spacer(modifier = Modifier.width(8.dp))

                Column {
                    Text(
                        selectedMode,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    if (selectedMode.equals("Online")) {
                        Text(
                            "$ $totalAmount",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = LightBrown
                            )
                        )
                    } else {
                        Text(
                            "$ ${totalAmount + 1}",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = LightBrown
                            )
                        )
                    }
                }

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Column {
                        Icon(
                            painter = painterResource(if (!changeIcon) R.drawable.regular_outline_arrow_up else R.drawable.regular_outline_arrow_down),
                            contentDescription = "Arrow down",
                            modifier = Modifier
                                .size(20.dp)
                                .clickable {
                                    expanded = true
                                    if (!changeIcon) changeIcon = true else changeIcon = false
                                }
                        )

                        DropdownMenu(
                            expanded = expanded == true,
                            onDismissRequest = {
                                expanded = false
                                if (!changeIcon) changeIcon = true else changeIcon = false
                            }
                        ) {
                            payModes.forEach() { it ->
                                DropdownMenuItem(
                                    text = { Text(it, style = MaterialTheme.typography.bodyLarge) },
                                    onClick = {
                                        selectedMode = it
                                        expanded = false
                                        if (!changeIcon) changeIcon = true else changeIcon = false
                                    },
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(if (selectedMode == it) R.drawable.mobile_banking else R.drawable.wallet),
                                            contentDescription = "Mode of Payment",
                                            modifier = Modifier.size(20.dp),
                                            tint = LightBrown
                                        )
                                    },
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .background(
                                            color = if (selectedMode == it) LightBrown.copy(alpha = 0.15f)
                                            else Color.Transparent
                                        )
                                )
                            }
                        }

                    }

                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBrown,
                    contentColor = Color.White
                )
            ) {
                Text("Placed Order", fontSize = 18.sp)
            }
        }
    }
}

