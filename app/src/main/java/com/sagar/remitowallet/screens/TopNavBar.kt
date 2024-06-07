package com.sagar.remitowallet.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun TopNavBar(
    title: String? = null,
    onBack: (() -> Unit)? = null,
    color: Color? = Color.White
){
    TopAppBar(
        title = { title },
        navigationIcon = {
            IconButton(onClick = {
                if(onBack != null) onBack()
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(color ?: Color.White)
    )
}