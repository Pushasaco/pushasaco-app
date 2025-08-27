package com.pushasaco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pushasaco.ui.screens.MessagesScreen
import com.pushasaco.ui.screens.RoomsScreen
import com.pushasaco.ui.screens.WalletScreen

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MaterialTheme {
        val nav = rememberNavController()
        NavHost(navController = nav, startDestination = "rooms") {
          composable("rooms") { RoomsScreen(onOpenRoom = { id -> nav.navigate("messages/$id") }, onOpenWallet = { nav.navigate("wallet") }) }
          composable("messages/{roomId}") { backStack ->
            val rid = backStack.arguments?.getString("roomId") ?: "demo"
            MessagesScreen(roomId = rid, onBack = { nav.popBackStack() })
          }
          composable("wallet") { WalletScreen(onBack = { nav.popBackStack() }) }
        }
      }
    }
  }
}

@Preview
@Composable
fun PreviewApp() {
  MaterialTheme { }
}