package com.sagar.remitowallet.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.sagar.remitowallet.R

@Composable
fun BottomNavBar(
    color: Color?= Color.White
){
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Yield", "Pay", "Home", "Swap", "Account")
    val icons = listOf(
        R.drawable.baseline_monetization_on_24,
        R.drawable.baseline_payment_24,
        Icons.Filled.Home,
        R.drawable.baseline_swap_horizontal_circle_24,
        Icons.Filled.AccountCircle
    )

    if (color != null) {
        NavigationBar(
            containerColor = color
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        if (icons[index] is Int)
                            Icon(
                                painter = painterResource(id = icons[index] as Int),
                                contentDescription = item
                            )
                        else
                            Icon(
                                imageVector = icons[index] as ImageVector,
                                contentDescription = item
                            )
                    },
                    label = { Text(item) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index },
                    alwaysShowLabel = false
                )
            }
        }
    }
}