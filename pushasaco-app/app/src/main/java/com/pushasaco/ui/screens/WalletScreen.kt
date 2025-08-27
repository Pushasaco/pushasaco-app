package com.pushasaco.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WalletScreen(onBack: () -> Unit) {
  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("Wallet") },
        navigationIcon = { IconButton(onClick = onBack) { Text("<") } }
      )
    }
  ) { pad ->
    Column(Modifier.padding(pad).padding(16.dp)) {
      Text("Crypto module is modular & disabled by default.", style = MaterialTheme.typography.bodyLarge)
      Spacer(Modifier.height(8.dp))
      Text("To enable, uncomment web3j/bitcoinj in app/build.gradle.kts and wire your RPC endpoints.", style = MaterialTheme.typography.bodyMedium)
    }
  }
}