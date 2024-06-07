package com.sagar.remitowallet.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.sagar.remitowallet.R


@Composable
fun WalletHome() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        /*bottomBar = {
            Row(
                modifier = Modifier
                    .height(56.dp)
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                }
                IconButton(
                    onClick = { },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(painter = painterResource(id = R.drawable.baseline_history_24), contentDescription = "History")
                }
                IconButton(
                    onClick = { },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                }
                IconButton(
                    onClick = { },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                }
            }
        }*/

        bottomBar = {
            BottomNavBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1C1678))
                .padding(innerPadding)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .size(48.dp)
                        .clip(shape = RoundedCornerShape(200.dp))
                        .background(Color(0xFF7BC9FF))
                ) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                }

                IconButton(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .size(48.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(Color(0xFF7BC9FF))
                ) {
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = null)
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .padding(16.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .shadow(2.dp)
            ) {
                Column(
                    Modifier.padding(16.dp),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        var showBalance by remember {
                            mutableStateOf(false)
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = if (showBalance) "$100.00" else "$*******",
                                fontSize = 25.sp, fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.width(8.dp))

                            if (showBalance)
                                IconButton(onClick = { showBalance = !showBalance }) {
                                    Icon(
                                        painter = painterResource(R.drawable.baseline_visibility_24),
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                            else
                                IconButton(onClick = { showBalance = !showBalance }) {
                                    Icon(
                                        painter = painterResource(R.drawable.baseline_visibility_off_24),
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                        }

                        var showDialog by remember { mutableStateOf(false) }

                        Image(
                            painter = painterResource(R.drawable.baseline_qr_code_2_24),
                            contentDescription = null,
                            modifier = Modifier
                                .size(72.dp)
                                .clickable {
                                    showDialog = true
                                }
                        )

                        if (showDialog) {
                            Dialog(onDismissRequest = { showDialog = false }) {
                                Card {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        contentAlignment = Alignment.Center,
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.baseline_qr_code_2_24),
                                            contentDescription = "QR Code", // Provide a descriptive content description
                                            modifier = Modifier
                                                .size(200.dp)
                                                .padding(16.dp), // Add padding for better visual appeal
                                        )
                                    }

                                    Text(
                                        text = "0x0000000000000000000000000000000000000",
                                        modifier = Modifier.padding(
                                            start = 16.dp,
                                            end = 16.dp,
                                            bottom = 8.dp
                                        ),
                                        fontWeight = FontWeight.SemiBold
                                    )

                                    Text(text = "Click on address to copy on clipboard 📋",
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.padding(16.dp))
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(
                            onClick = { /*TODO*/ }, modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .size(48.dp)
                                .clip(shape = RoundedCornerShape(16.dp))
                                .background(Color.Gray)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_call_made_24),
                                contentDescription = null,
                                tint = Color.Black
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        IconButton(
                            onClick = { /*TODO*/ }, modifier = Modifier
                                .fillMaxWidth(1f)
                                .size(48.dp)
                                .clip(shape = RoundedCornerShape(16.dp))
                                .background(Color.Gray)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_call_received_24),
                                contentDescription = null,
                                tint = Color.Black
                            )
                        }
                    }
                }
            }


            // Transactions
            Text(
                text = "Transactions",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            Divider(
                color = Color(0xFFA3FFD6), modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally)
            )
            Box(
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Image(
                            painter = painterResource(R.drawable.baseline_currency_bitcoin_24),
                            contentDescription = null,
                            modifier = Modifier
                                .size(48.dp)
                                .clip(shape = RoundedCornerShape(16.dp))
                                .background(Color.LightGray),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(
                                text = "Bitcoin",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "Bitcoin",
                                fontSize = 15.sp,
                                color = Color.White
                            )
                        }
                    }

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_call_made_24),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }

            Divider(
                color = Color(0xFFA3FFD6), modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally)
            )


        }
    }
}

@Preview(showBackground = true)
@Composable
fun WalletHomePreview() {
    WalletHome()
}