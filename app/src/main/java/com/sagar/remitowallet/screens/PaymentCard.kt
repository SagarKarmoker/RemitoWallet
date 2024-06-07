package com.sagar.remitowallet.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sagar.remitowallet.R

@Composable
fun PaymentCard() {
    val gradientColors = listOf(Color(0xFF22c1c3), Color(0xFFfdbb2d))

    Card {
        Box(
            modifier = Modifier
                .size(width = 350.dp, height = 200.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = gradientColors
                    )
                )
                .padding(16.dp)

        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Remito Wallet",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Image(
                        painter = painterResource(R.drawable.baseline_currency_bitcoin_24),
                        contentDescription = "logo"
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "1234 5679 8901 1234", fontWeight = FontWeight.Bold, color = Color.White,
                    fontSize = 25.sp
                )

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Card Holder",
                            fontWeight = FontWeight.Normal,
                            color = Color.White,
                            fontSize = 15.sp
                        )
                        Text(
                            text = "SAGAR KARMOKER",
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                    Column {
                        Text(
                            text = "Expiry Date",
                            fontWeight = FontWeight.Normal,
                            color = Color.White,
                            fontSize = 15.sp
                        )
                        Text(
                            text = "01/29", fontWeight = FontWeight.SemiBold, color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.mastercard),
                        contentDescription = "logo",
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
        }
    }

}

@Composable
fun PaymentCardBack() {
    val gradientColors = listOf(Color(0xFF22c1c3), Color(0xFFfdbb2d))

    Card {
        Box(
            modifier = Modifier
                .size(width = 350.dp, height = 200.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = gradientColors
                    )
                )
        ) {
            Column(
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Customer Care: 16247", modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center, color = Color.White,
                    fontSize = 10.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(Color.Black)
                ) {
                    Text(text = "")
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp)
                        .height(40.dp)
                        .background(Color.Gray)

                ) {
                    Text(
                        text = "CVV: 123", textAlign = TextAlign.End, color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp), fontWeight = FontWeight.Bold
                    )
                }

                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                    modifier = Modifier.padding(
                        top = 8.dp,
                        bottom = 8.dp,
                        start = 16.dp,
                        end = 16.dp
                    ),
                    color = Color.White,
                    fontSize = 12.sp,
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewPaymentCard() {
    PaymentCardBack()
}