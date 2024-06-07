package com.sagar.remitowallet.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sagar.remitowallet.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(){
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Payment",
                    textAlign = TextAlign.Center,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    fontFamily = FontFamily.Cursive
                )
            })
        },
        bottomBar = {
            BottomNavBar()
        }

    ) {
        innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    var flipcard by remember {
                        mutableStateOf(false)
                    }
                    val angle by animateFloatAsState(
                        targetValue = if (flipcard) 180f else 0f
                    )
                    Card(
                        modifier = Modifier
                            .padding(16.dp)
                            .shadow(
                                elevation = 8.dp,
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp)
                            )
                            .clickable {
                                flipcard = !flipcard
                            }
                            .graphicsLayer {
                                rotationY = 90f * angle
                            }
                            .animateContentSize(
                                animationSpec = tween(
                                    durationMillis = 500,
                                    delayMillis = 200,
                                    easing = LinearEasing // Or any other easing you prefer
                                )
                            )
                    ) {
                        if (!flipcard) {
                            PaymentCard()
                        }
                        else {
                            PaymentCardBack()
                        }
                    }
                }

                Transactions()
            }
        }
    }
}

@Composable
fun Transactions(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Transactions",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
            Text(text = "See All",
                fontSize = 20.sp,
                color = Color.Blue,
                fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Today",
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal)
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(5) { index ->
                Tx()
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tx(){
    Card(onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        colors = CardDefaults.cardColors(Color.LightGray)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            //image
            Row {
                Image(
                    painter = painterResource(R.drawable.baseline_call_made_24),
                    contentDescription = null,
                    modifier = Modifier.height(48.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                //column
                Column {
                    Text(
                        text = "Adobe Photoshop",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Subscription Fee",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
            //amount
            Text(text = "-$32.00",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PaymentScreenPreview(){
    PaymentScreen()
}