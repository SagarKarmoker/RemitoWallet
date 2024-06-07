package com.sagar.remitowallet.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sagar.remitowallet.R
import com.sagar.remitowallet.ui.theme.greeny

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwapScreen() {
    Scaffold(
        topBar = {
            TopNavBar(
                color = greeny,
                title = "Swap"
            )
        },
        bottomBar = {
            BottomNavBar()
        },
        containerColor = greeny
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = greeny
        ) {
            var fromCurrency = remember { mutableStateOf("BTC") }
            var toCurrency = remember { mutableStateOf("USD") }

            var fromAmount = remember { mutableStateOf("0.00") }
            var toAmount = remember { mutableStateOf("0.00") }

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 16.dp,
                    )
            ) {
                OutlinedTextField(
                    value = fromAmount.value, onValueChange = {
                        fromAmount.value = it
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    trailingIcon = {
                        /*IconButton(onClick = { *//*TODO*//* }) {
                            Image(
                                imageVector = ImageVector.vectorResource(id = R.drawable.btc),
                                contentDescription = "Dropdown"
                            )
                        }*/
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = greeny,
                        unfocusedBorderColor = greeny,
                    ),
                    placeholder = {
                        Text(text = "Select Currency")
                    },
                    textStyle = TextStyle(
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif
                    ),
                    prefix = {
                        Text(
                            text = fromCurrency.value,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif
                        )
                    }
                )

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Divider(color = Color.Black)
                    IconButton(
                        onClick = {
                            val currencyAmountChange = fromAmount.value
                            fromAmount.value = toAmount.value
                            toAmount.value = currencyAmountChange

                            val currencyChange = fromCurrency.value
                            fromCurrency.value = toCurrency.value
                            toCurrency.value = currencyChange
                        },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.fab_swap),
                            contentDescription = "Swap"
                        )
                    }
                }

                OutlinedTextField(
                    value = toAmount.value, onValueChange = {
                        toAmount.value = it
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    trailingIcon = {
                        /*IconButton(onClick = { *//*TODO*//* }) {
                            Image(
                                imageVector = ImageVector.vectorResource(id = R.drawable.btc),
                                contentDescription = "Dropdown"
                            )
                        }*/
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = greeny,
                        unfocusedBorderColor = greeny,
                    ),
                    placeholder = {
                        Text(text = "Select Currency")
                    },
                    textStyle = TextStyle(
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif
                    ),
                    prefix = {
                        Text(
                            text = toCurrency.value,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif
                        )
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    )

                ) {
                    Text(
                        text = "Swap",
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
fun SwapScreenPreview() {
    SwapScreen()
}