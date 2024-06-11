package com.sagar.remitowallet.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
                title = { Text(text = "Swap", color = Color.White) }
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

            var fromAmount = remember { mutableStateOf("") }
            var toAmount = remember { mutableStateOf("") }

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 16.dp,
                    )
            ) {
                Currency(fromCurrency, fromAmount)
                SwapCurrency(
                    fromCurrency,
                    toCurrency,
                    fromAmount,
                    toAmount
                )
                Currency(toCurrency, toAmount)
                Spacer(modifier = Modifier.height(16.dp))
                SwapButton()

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencySelect(){
    val currencies = listOf(
        painterResource(id = R.drawable.btc),
        painterResource(id = R.drawable.eth),
        painterResource(id = R.drawable.usdt)
    )

    val currenciesCode = listOf(
        "BTC","ETH","USDT"
    )

    var isExpanded by remember {
        mutableStateOf(false)
    }

    var selectedCurrency by remember {
        mutableStateOf(currencies[0])
    }

    var selectedCurrencyCode by remember {
        mutableStateOf(currenciesCode[0])
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(painter = selectedCurrency, contentDescription = selectedCurrencyCode,
                modifier = Modifier.menuAnchor().size(48.dp)
                )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                currencies.forEach { currency ->
                    DropdownMenuItem(
                        text = {
                            Image(
                                painter = currency,
                                contentDescription = selectedCurrencyCode,
                                modifier = Modifier
                                    .size(48.dp)
                            )
                        },
                        onClick = {
                            selectedCurrency = currency
                            isExpanded = false
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun SwapCurrency(
    fromCurrency: MutableState<String>,
    toCurrency: MutableState<String>,
    fromAmount: MutableState<String>,
    toAmount: MutableState<String>
) {
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
}

@Composable
fun Currency(
    currency: MutableState<String>,
    amount: MutableState<String>,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = amount.value,
            onValueChange = {
                amount.value = it
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = greeny,
                unfocusedBorderColor = greeny,
            ),
            placeholder = {
                Text(
                    text = "0.00", fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif
                )
            },
            textStyle = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            ),
            prefix = {
                Text(
                    text = currency.value,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif
                )
            },
        )

        CurrencySelect()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwapButton() {
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Column {
        Button(
            onClick = { showBottomSheet = true }, // Directly set to true
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

        if (showBottomSheet) { // Conditionally show ModalBottomSheet
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState
            ) {

                Text(
                    "Swapping cost", modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "Rate", color = Color.Gray)
                        Text(text = "Network Fees", color = Color.Gray)
                        Text(text = "Price Impact", color = Color.Gray)
                    }
                    Column {
                        Text(text = "1 BTC = 10000 USD", color = Color.Blue)
                        Text(text = "$0.25")
                        Text(text = "0.15%")
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Sheet content
                    Button(
                        onClick = {
                            //SwapConfirmScreen()
//                        Navigate to SwapConfirmScreen using your preferred navigation method
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Confirm swap")
                    }
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