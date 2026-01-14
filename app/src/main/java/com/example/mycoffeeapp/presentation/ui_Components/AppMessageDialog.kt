package com.example.mycoffeeapp.presentation.ui_Components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.example.mycoffeeapp.presentation.theme.LightBrown


@Composable
fun AppMessageDialog(
    show: Boolean,
    title: String,
    message: String,
    button1: String,
    button2: String,
    onDismiss: () -> Unit,
    onClick: () -> Unit,
) {
    if (show) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(text = title) },
            text = { Text(text = message) },
            confirmButton = { TextButton(onClick = onClick) { Text(button1, color = LightBrown) } },
            dismissButton = {TextButton(onClick = onDismiss) { Text(button2, color = LightBrown) }}
        )
    }
}