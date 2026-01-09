package com.example.mycoffeeapp.presentation.ui_Components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.presentation.theme.LightBrown

@Preview(showBackground = true)
@Composable
fun MyBottomNavBar() {
    //Bottom Nav Item
    val navItem =  listOf(
        NavItem(title = "Home", icon = R.drawable.regular_outline_home ),
        NavItem(title = "Cart", icon = R.drawable.regular_outline_bag ),
        NavItem(title = "Favourite", icon = R.drawable.regular_outline_heart ),
        NavItem(title = "Profile", icon = R.drawable.outline_account_circle_24 )
    )

    NavigationBar(containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.height(80.dp)) {
        navItem.forEachIndexed{index, item->
            NavigationBarItem(
                icon = { Icon(painter = painterResource(item.icon), contentDescription = item.title) },
                label = { Text(item.title) },
                modifier = Modifier.size(30.dp),
                onClick = {},
                selected = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = LightBrown,
                    selectedIconColor = LightBrown,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = LightBrown.copy(alpha = 0.03f)
                )
            )
        }
    }
}

data class NavItem(
    val title: String,
    val icon: Int
)