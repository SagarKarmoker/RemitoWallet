package com.sagar.remitowallet.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sagar.remitowallet.R
import com.sagar.remitowallet.ui.theme.bodyColor
import com.sagar.remitowallet.ui.theme.greeny
import com.sagar.remitowallet.ui.theme.lightGreen

@Composable
fun WalletDashboard() {
    Scaffold(
        bottomBar = {
            BottomNavBar()
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = bodyColor
        ) {
            Column {
                Spacer(modifier = Modifier.height(60.dp))
                Text(
                    text = "$840.20",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 50.sp, fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Monospace
                )

                PriceChange()
                ActionButtons()

                //holding card
                Card(
                    modifier = Modifier.fillMaxSize(1f),
                    shape = RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 30.dp
                    ),
                    colors = CardDefaults.cardColors(Color.White),
                ) {
                    Column(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = "Holdings",
                            fontSize = 15.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(top = 16.dp),
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        LazyColumn {
                            items(15) {
                                CurrencyCard()
                                Divider(Modifier.padding(top = 8.dp))
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun PriceChange() {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 8.dp),
            colors = CardDefaults.cardColors(greeny),
            border = BorderStroke(1.dp, Color.Black),
            shape = RoundedCornerShape(100.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_priceup_24),
                    contentDescription = null,
                    modifier = Modifier.padding(16.dp)
                )
                Text(
                    text = "+3.9% (+16.80)",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    ),
                )
            }
        }
    }
}

@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val interactionSource = remember { MutableInteractionSource() }

        Image(
            modifier = Modifier.clickable(
                interactionSource = interactionSource,
                indication = null,
            ) {

            },
            imageVector = ImageVector.vectorResource(id = R.drawable.receive),
            contentDescription = "receive"
        )
        Image(
            modifier = Modifier.clickable(
                interactionSource = interactionSource,
                indication = null,
            ) {

            },
            imageVector = ImageVector.vectorResource(id = R.drawable.send),
            contentDescription = "send"
        )
        Image(
            modifier = Modifier.clickable(
                interactionSource = interactionSource,
                indication = null,
            ) {

            },
            imageVector = ImageVector.vectorResource(id = R.drawable.swap),
            contentDescription = "swap"
        )
        Image(
            modifier = Modifier.clickable (
                interactionSource = interactionSource,
                indication = null,
            ){

            },
            imageVector = ImageVector.vectorResource(id = R.drawable.buy),
            contentDescription = "buy"
        )
        Image(
            modifier = Modifier.clickable(
                interactionSource = interactionSource,
                indication = null,
            ) {

            },
            imageVector = ImageVector.vectorResource(id = R.drawable.sell),
            contentDescription = "sell"
        )
    }
}

@Composable
fun CurrencyCard(){
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        Modifier.fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
            ) {

            },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.btc),
                contentDescription = "btc",
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text(
                    text = "Bitcoin",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = "BTC~$38,049",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }
        }
        Column{
            Text(
                text = "$2387.00",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = "+14.00%",
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = lightGreen,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun WalletDashboardPreview() {
    WalletDashboard()
}