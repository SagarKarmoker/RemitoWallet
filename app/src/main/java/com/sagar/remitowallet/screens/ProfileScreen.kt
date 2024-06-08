package com.sagar.remitowallet.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Profile",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                end = 16.dp
                            ),
                        textAlign = TextAlign.Center
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.White),
                modifier = Modifier.fillMaxWidth()
            )
        },
        bottomBar = {
            BottomNavBar()
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = Color.White
        ) {
            Column {
                Divider()
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                        .background(color = Color.Gray)
                )
                User()
                BlackSeparator()
                LazyColumn(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp
                    )
                ) {
                    items(10) {
                        Options(
                            optionName = "Account Profile",
                            optionDetails = "Your account profile"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    item {
                        LogOut()
                    }
                }
            }
        }
    }
}

@Composable
fun LogOut() {
    TextButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Log out",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Blue
        )
    }

    Text(
        text = "Version 1.0.0",
        modifier = Modifier.fillMaxWidth(),
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center
    )


    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Made with ❤️ of Decentralization",
        modifier = Modifier.fillMaxWidth(),
        fontSize = 15.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun Options(
    optionName: String? = null,
    icon: Int? = null,
    optionDetails: String? = null,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    bottom = 12.dp,
                    top = 12.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.Face, contentDescription = "more")
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    if (optionName != null) {
                        Text(text = optionName, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                    }
                    if (optionDetails != null) {
                        Text(text = optionDetails, fontWeight = FontWeight.Normal, fontSize = 12.sp)
                    }
                }
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "more")
            }
        }
    }
}

@Composable
fun BlackSeparator(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Black)
            .height(50.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "📢 Invite your friends, Earn Reward Together!", color = Color.White)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun User() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp, end = 16.dp, bottom = 16.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.btc),
                contentDescription = "Profile Image",
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = "Sagar Karmoker", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                Text(
                    text = "@SagarKarmoker", fontWeight = FontWeight.SemiBold, fontSize = 15.sp,
                    color = Color.Gray
                )
            }
        }

        Card(
            onClick = { /*TODO*/ },
            colors = CardDefaults.cardColors(Color.Black),
            shape = CircleShape
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Verified",
                    modifier = Modifier.padding(16.dp, end = 0.dp),
                    color = Color.White
                )
                Image(
                    painter = painterResource(id = R.drawable.baseline_verified_24),
                    contentDescription = "Verified",
                    modifier = Modifier.padding(8.dp),
                    colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.Green)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewProfileScreen() {
    ProfileScreen()
}