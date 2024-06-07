package com.sagar.remitowallet.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.sagar.remitowallet.R

@Composable
fun SendScreen() {
    Scaffold(
        topBar = {
            TopNavBar(
                onBack = {
                    //navController.popBackStack()
                }
            )
        },
        bottomBar = {
            BottomNavBar()
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column {
                val address = remember {
                    mutableStateOf("")
                }
                OutlinedTextField(
                    value =
                    address.value, onValueChange = {
                        address.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp
                        ),
                    label = {
                        Text(text = "Receiver Address")
                    },
                    leadingIcon = {
                        Text(text = "0x")
                    }
                )

                val currency = remember {
                    mutableStateOf("ETH")
                }
                OutlinedTextField(
                    value =
                    address.value, onValueChange = {
                        address.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    label = {
                        Text(text = "Amount")
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.twotone_attach_money_24),
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                if (currency.value == "ETH")
                                    currency.value = "USD"
                                else
                                    currency.value = "ETH"
                            },
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .clip(shape = RoundedCornerShape(200.dp))
                                .background(color = Color.LightGray)

                        ) {
                            Text(
                                text = currency.value,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                )

                // Define gas price options as a data class for better structure
                data class GasPriceOption(val emoji: String, val label: String, val price: String)

                // List of available gas price options
                val gasPriceOptions = listOf(
                    GasPriceOption("\uD83D\uDE80", "Faster", "18"),
                    GasPriceOption("\uD83C\uDFC7", "Average", "12"),
                    GasPriceOption("\uD83D\uDC22", "Slow", "5")
                )

                DropdownWithOutlinedTextField()

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clip(shape = RectangleShape)
                ) {
                    Text(
                        text = "Send",
                        Modifier.padding(8.dp),
                        fontSize = 15.sp
                    )
                }

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Current Gas Cost (Per Transaction) \n" +
                                "power by Etherscan",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                    Text(
                        text = "🚀 Faster = 18 Gwei",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(4.dp)
                    )
                    Text(
                        text = "🏇 Average = 12 Gwei",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(4.dp)
                    )
                    Text(
                        text = "🐢 Slow = 5 Gwei",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(4.dp)
                    )

                    Spacer(modifier = Modifier.height(48.dp))
                    Text(
                        text = "Current ETH Rate 📈",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    )

                    Text(
                        text = "1 ETH ~ 2000 USD*",
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    )
                }


                Text(
                    text = "*Price by Coinmarketcap",
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .align(Alignment.End)
                )
            }
        }
    }
}

@Composable
fun DropdownWithOutlinedTextField() {
    // This is needed for calculating the width of the TextField
    var textfieldSize by remember { mutableStateOf(Size.Zero) }
    var expanded by remember { mutableStateOf(false) }
    var selectedGasPrice by remember { mutableStateOf("Select Gas Price") }
    val gasPriceOptions = listOf(
        GasPriceOption("🐢", "Slow", "5"),
        GasPriceOption("🏇", "Average", "12"),
        GasPriceOption("🚀", "Faster", "18")
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopStart)
    ) {
        Column(Modifier.padding(16.dp)) {
            OutlinedTextField(
                value = selectedGasPrice,
                onValueChange = { selectedGasPrice = it },
                readOnly = true,
                modifier = Modifier
                    .clickable {
                        expanded = !expanded // Toggle the dropdown menu
                    }
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        // This value is used to assign to the DropDown the same width
                        textfieldSize = coordinates.size.toSize()
                    },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null,
                        Modifier.clickable { expanded = !expanded })
                },
                leadingIcon = {
                    Text(text = "⛽")
                },

                )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
                    .background(Color.LightGray)
            ) {
                gasPriceOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(text = "${option.emoji} ${option.label} ${option.price} Gwei") },
                        onClick = {
                            selectedGasPrice =
                                "${option.emoji} ${option.label} ${option.price} Gwei"
                            expanded = false // Close the menu after selection
                        }
                    )
                }
            }
        }
    }
}

// Data class for gas price options
data class GasPriceOption(val emoji: String, val label: String, val price: String)


@Composable
@Preview(showBackground = true)
fun SendScreenPreview() {
    SendScreen()
}