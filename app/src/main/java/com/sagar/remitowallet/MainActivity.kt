package com.sagar.remitowallet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sagar.remitowallet.screens.ProfileScreen
import com.sagar.remitowallet.ui.theme.RemitoWalletTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RemitoWalletTheme {
                //WalletHome()
                //SendScreen()
                //PaymentScreen()
                //WalletDashboard()
                //SwapScreen()
                //SwapConfirmScreen()
                ProfileScreen()
            }
        }
    }
}
