package com.sagar.remitowallet
//
//import android.content.Intent
//import android.net.Uri
//import android.os.Bundle
//import android.util.Log
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
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
//import androidx.compose.ui.unit.dp
//import com.google.gson.Gson
//import com.sagar.remitowallet.ui.theme.RemitoWalletTheme
//import com.web3auth.core.Web3Auth
//import com.web3auth.core.types.BuildEnv
//import com.web3auth.core.types.ExtraLoginOptions
//import com.web3auth.core.types.LoginParams
//import com.web3auth.core.types.Network
//import com.web3auth.core.types.Provider
//import com.web3auth.core.types.Web3AuthOptions
//import com.web3auth.core.types.Web3AuthResponse
//import org.web3j.crypto.Credentials
//import org.web3j.protocol.Web3j
//import org.web3j.protocol.http.HttpService
//import java.util.concurrent.CompletableFuture
//
//class MainActivity : ComponentActivity() {
//
//    private lateinit var web3Auth: Web3Auth
//    private lateinit var web3: Web3j
//    private lateinit var credentials: Credentials
//    private val rpcUrl = "https://rpc.ankr.com/eth_sepolia"
//    private val gson = Gson()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        web3Auth = Web3Auth(
//            Web3AuthOptions(
//                context = this,
//                clientId = "BN2DxI4_8q8R6E0O-JCKTgjktRB8fsjRlVqxlpdwJn1iix5omIDarfWFiZjGOqHstSz7C0yvLyP4PnjB985RvUE",
//                network = Network.SAPPHIRE_DEVNET, // pass over the network you want to use (MAINNET or TESTNET or CYAN, AQUA, SAPPHIRE_MAINNET or SAPPHIRE_TESTNET)
//                buildEnv = BuildEnv.PRODUCTION,
//                redirectUrl = Uri.parse("com.sagar.remitowallet://auth")
//            )
//        )
//        web3Auth.setResultUrl(intent?.data)
//        val sessionResponse: CompletableFuture<Void> = web3Auth.initialize()
//
//        sessionResponse.whenComplete { _, error ->
//            if (error == null) {
//                reRender()
//                println("PrivKey: " + web3Auth.getPrivkey())
//                println("ed25519PrivKey: " + web3Auth.getEd25519PrivKey())
//                println("Web3Auth UserInfo" + web3Auth.getUserInfo())
//                credentials = Credentials.create(web3Auth.getPrivkey())
//                web3 = Web3j.build(HttpService(rpcUrl))
//            } else {
//                Log.d("MainActivity_Web3Auth", error.message ?: "Something went wrong")
//                // Ideally, you should initiate the login function here.
//            }
//        }
//
//        enableEdgeToEdge()
//        setContent {
//            RemitoWalletTheme {
//                //WalletHome()
//                //SendScreen()
//                //PaymentScreen()
//                //WalletDashboard()
//                //SwapScreen()
//                //SwapConfirmScreen()
//                //ProfileScreen()
//                Auth()
//            }
//        }
//    }
//
//    @Composable
//    @Preview(showBackground = true)
//    fun Auth() {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            Column(
//                modifier = Modifier.fillMaxSize(),
//            ) {
//                var email by remember {
//                    mutableStateOf("")
//                }
//                Spacer(modifier = Modifier.height(100.dp))
//                TextField(value = email, onValueChange = {
//                    email = it
//                })
//
//                Button(onClick = {
//                    signIn(email)
//                }) {
//                    Text(text = "Login")
//                }
//
//                //Text(text = "My Account: + ${getAddress()}")
//
//            }
//        }
//    }
//
//    override fun onNewIntent(intent: Intent?) {
//        if (intent != null) {
//            super.onNewIntent(intent)
//        }
//
//        // Handle user signing in when app is active
//        intent?.data?.let {
//            web3Auth.setResultUrl(it)
//        }
//    }
//
//    private fun signIn(
//        email: String
//    ) {
//        val selectedLoginProvider =
//            Provider.EMAIL_PASSWORDLESS   // Can be GOOGLE, FACEBOOK, TWITCH etc.
//        val loginParams = LoginParams(
//            selectedLoginProvider,
//            extraLoginOptions = ExtraLoginOptions(login_hint = email)
//        )
//        val loginCompletableFuture: CompletableFuture<Web3AuthResponse> =
//            web3Auth.login(loginParams)
//
//        loginCompletableFuture.whenComplete { _, error ->
//            if (error == null) {
//                // Set the sessionId from Web3Auth in App State
//                // This will be used when making blockchain calls with Web3j
//                credentials = Credentials.create(web3Auth.getPrivkey())
//                web3 = Web3j.build(HttpService(rpcUrl))
//                //reRender()
//                Log.d("MainActivity_Web3Auth", "Add: ${getAddress()}")
//            } else {
//                Log.d("MainActivity_Web3Auth", error.message ?: "Something went wrong")
//            }
//        }
//    }
//
//    private fun getAddress(): String {
//        val publicAddress = credentials.address
//        return publicAddress
//    }
//
//    private fun signOut() {
//        val logoutCompletableFuture = web3Auth.logout()
//        logoutCompletableFuture.whenComplete { _, error ->
//            if (error == null) {
//                reRender()
//            } else {
//                Log.d("MainActivity_Web3Auth", error.message ?: "Something went wrong")
//            }
//        }
//        recreate()
//    }
//
//    private fun reRender() {
//        TODO("Not yet implemented")
//    }
//}

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.web3auth.core.Web3Auth
import com.web3auth.core.types.BuildEnv
import com.web3auth.core.types.ExtraLoginOptions
import com.web3auth.core.types.LoginParams
import com.web3auth.core.types.Network
import com.web3auth.core.types.Provider
import com.web3auth.core.types.Web3AuthOptions
import com.web3auth.core.types.Web3AuthResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.web3j.crypto.Credentials
import org.web3j.crypto.Hash
import org.web3j.crypto.Sign
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.protocol.core.methods.response.EthGetBalance
import org.web3j.protocol.http.HttpService
import org.web3j.utils.Numeric
import java.math.BigInteger
import java.nio.charset.StandardCharsets
import java.util.concurrent.CompletableFuture

class MainActivity : ComponentActivity() {

    private lateinit var web3Auth: Web3Auth
    private lateinit var web3: Web3j
    private lateinit var credentials: Credentials
    private val rpcUrl = "https://11155111.rpc.thirdweb.com"
    private val gson = Gson()

    private val _isLoggedIn = mutableStateOf(false)
    private val _userInfo = mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Web3AuthDemoApp()
        }

        web3Auth = Web3Auth(
            Web3AuthOptions(
                context = this,
                clientId = "BN2DxI4_8q8R6E0O-JCKTgjktRB8fsjRlVqxlpdwJn1iix5omIDarfWFiZjGOqHstSz7C0yvLyP4PnjB985RvUE",
                network = Network.SAPPHIRE_DEVNET,
                buildEnv = BuildEnv.PRODUCTION,
                redirectUrl = Uri.parse("com.sagar.remitowallet://auth")
            )
        )

        // Handle user signing in when app is not alive
        web3Auth.setResultUrl(intent?.data)

        // Call initialize() in onCreate() to check for any existing session.
        val sessionResponse: CompletableFuture<Void> = web3Auth.initialize()
        sessionResponse.whenComplete { _, error ->
            if (error == null) {
                lifecycleScope.launch(Dispatchers.IO) {
                    initializeWeb3()
                }
            } else {
                Log.d("MainActivity_Web3Auth", error.message ?: "Something went wrong")
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        intent.data?.let {
            Log.d("MainActivity", "Received new intent with data: $it")
            web3Auth.setResultUrl(it)
        }
    }

    private fun initializeWeb3() {
        credentials = Credentials.create(web3Auth.getPrivkey())
        web3 = Web3j.build(HttpService(rpcUrl))
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    @Preview(showBackground = true)
    fun Web3AuthDemoApp() {
        var email by remember { mutableStateOf(TextFieldValue()) }
        var userInfo by remember { _userInfo }
        var content by remember { mutableStateOf("") }
        var isLoggedIn by remember { _isLoggedIn }

        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Web3Auth Demo") })
            },
            content = { padding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(16.dp)
                ) {
                    if (!isLoggedIn) {
                        TextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Email") }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { signIn(email.text) }) {
                            Text("Sign In")
                        }
                    } else {
                        Text(text = userInfo)
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { signOut() }) {
                            Text("Sign Out")
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { content = getAddress() }) {
                            Text("Get Address")
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { content = getBalance()?.toString() ?: "Error" }) {
                            Text("Get Balance")
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { content = signMessage("Welcome to Web3Auth") }) {
                            Text("Sign Message")
                        }
//                        Spacer(modifier = Modifier.height(8.dp))
//                        Button(onClick = { content = sendTransaction(0.001, "0xeaA8Af602b2eDE45922818AE5f9f7FdE50cFa1A8") ?: "Error" }) {
//                            Text("Send Transaction")
//                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = content)
                }
            }
        )
    }

    private fun signIn(email: String) {
        val selectedLoginProvider = Provider.EMAIL_PASSWORDLESS
        val loginParams = LoginParams(selectedLoginProvider, extraLoginOptions = ExtraLoginOptions(login_hint = email))
        val loginCompletableFuture: CompletableFuture<Web3AuthResponse> = web3Auth.login(loginParams)

        loginCompletableFuture.whenComplete { _, error ->
            if (error == null) {
                credentials = Credentials.create(web3Auth.getPrivkey())
                web3 = Web3j.build(HttpService(rpcUrl))
                _userInfo.value = gson.toJson(web3Auth.getUserInfo()) + "\n Private Key: " + web3Auth.getPrivkey()
                _isLoggedIn.value = true
                Log.d("USER", _userInfo.value)
            } else {
                Log.d("MainActivity_Web3Auth", error.message ?: "Something went wrong")
            }
        }
    }

    private fun signOut() {
        val logoutCompletableFuture = web3Auth.logout()
        logoutCompletableFuture.whenComplete { _, error ->
            if (error == null) {
                _isLoggedIn.value = false
                _userInfo.value = ""
            } else {
                Log.d("MainActivity_Web3Auth", error.message ?: "Something went wrong")
            }
        }
    }

    private fun getAddress(): String {
        Log.d("USER", credentials.address)
        return credentials.address
    }

    private fun getBalance(): BigInteger? {
        val publicAddress = credentials.address
        val ethBalance: EthGetBalance = web3.ethGetBalance(publicAddress, DefaultBlockParameterName.LATEST).sendAsync().get()
        Log.d("USER", ethBalance.balance.toString())
        return ethBalance.balance
    }

    private fun signMessage(message: String): String {
        val hashedData = Hash.sha3(message.toByteArray(StandardCharsets.UTF_8))
        val signature = Sign.signMessage(hashedData, credentials.ecKeyPair)
        val r = Numeric.toHexString(signature.r)
        val s = Numeric.toHexString(signature.s).substring(2)
        val v = Numeric.toHexString(signature.v).substring(2)
        return StringBuilder(r).append(s).append(v).toString()
    }

    /*private fun sendTransaction(amount: Double, recipientAddress: String): String? {
        val ethGetTransactionCount: EthGetTransactionCount = web3.ethGetTransactionCount(credentials.address, DefaultBlockParameterName.LATEST).sendAsync().get()
        val nonce: BigInteger = ethGetTransactionCount.transactionCount
        val value: BigInteger = Convert.toWei(amount.toString(), Convert.Unit.ETHER).toBigInteger()
        val gasLimit: BigInteger = BigInteger.valueOf(21000)
        val chainId: EthChainId = web3.ethChainId().sendAsync().get()

        val rawTransaction: RawTransaction = RawTransaction.createTransaction(
            chainId.chainId.toLong(),
            nonce,
            gasLimit,
            recipientAddress,
            value,
            "",
            BigInteger.valueOf(5000000000),
            BigInteger.valueOf(6000000000000)
        )

        val signedMessage: ByteArray = TransactionEncoder.signMessage(rawTransaction, credentials)
        val hexValue: String = Numeric.toHexString(signedMessage)
        val ethSendTransaction: EthSendTransaction = web3.ethSendRawTransaction(hexValue).sendAsync().get()
        return if (ethSendTransaction.error != null) {
            ethSendTransaction.error.message
        } else {
            ethSendTransaction.transactionHash
        }
    }*/
}
