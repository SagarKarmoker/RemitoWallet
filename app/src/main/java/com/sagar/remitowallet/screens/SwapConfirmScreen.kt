package com.sagar.remitowallet.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sagar.remitowallet.R
import com.sagar.remitowallet.ui.theme.bodyColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwapConfirmScreen(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "")
                },
                navigationIcon = {
                    // Back button
                    IconButton(
                        onClick = { /* Handle back button click */ }
                    ){
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(bodyColor)
            )
        }
    ) {
        innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = bodyColor
        ){
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Image(painter = painterResource(R.drawable.fab_swap), contentDescription = "swap icon",
                    modifier = Modifier
                        .size(size = 100.dp)
                        .padding(bottom = 16.dp))
                Text(text = "Swap has been completed", fontSize = 22.sp,
                    fontWeight = FontWeight.Bold)

                Text(text = "You just swapped 0.5BTC to get \n" +
                        "8.3ETH successfully.", color = Color.Gray,fontSize = 18.sp, textAlign = TextAlign.Center,  modifier = Modifier.padding(16.dp))

                Button(
                    onClick = {  },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    )
                ) {
                    Text(
                        text = "Swap Again",
                        fontSize = 15.sp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }

                Text(text = "or", color = Color.Gray, modifier = Modifier.padding(vertical = 8.dp))

                Button(
                    onClick = {  },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray
                    )
                ) {
                    Text(
                        text = "Continue to Home",
                        fontSize = 15.sp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewSwapRequestScreen(){
    SwapConfirmScreen()
}