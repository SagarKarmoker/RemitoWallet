//package com.sagar.remitowallet.web3
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.Button
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//
//@Composable
//fun Auth() {
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = MaterialTheme.colorScheme.background
//    ) {
//        Column {
//            var email by remember {
//                mutableStateOf("")
//            }
//            TextField(value = email, onValueChange = {
//                email = it
//            })
//
//            Button(onClick = { /*TODO*/ }) {
//                Text(text = "Login")
//            }
//        }
//    }
//}
//
//@Composable
//@Preview(showBackground = true)
//fun PreviewAuth() {
//    Auth()
//}
