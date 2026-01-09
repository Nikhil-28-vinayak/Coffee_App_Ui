package com.example.mycoffeeapp.presentation.screens.detailscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycoffeeapp.presentation.theme.LightGray

@Preview
@Composable
fun SelectSizeChip() {
    Box(
        modifier = Modifier
            .background(
                color = Color.White
            )
            .border(1.dp, LightGray)
            .clip(RoundedCornerShape(12.dp))
            .width(50.dp),
    ) {
        Text("M")
    }
}