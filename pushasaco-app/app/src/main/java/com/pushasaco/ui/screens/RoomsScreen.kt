package com.pushasaco.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RoomsScreen(onOpenRoom: (String) -> Unit, onOpenWallet: () -> Unit) {
  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("Pushasaco") },
        actions = { TextButton(onClick = onOpenWallet) { Text("Wallet") } }
      )
    }
  ) { pad ->
    Column(Modifier.padding(pad).padding(16.dp)) {
      Text("Demo rooms", style = MaterialTheme.typography.titleMedium)
      Spacer(Modifier.height(8.dp))
      Button(onClick = { onOpenRoom("general") }) { Text("Open #general") }
      Spacer(Modifier.height(8.dp))
      Button(onClick = { onOpenRoom("random") }) { Text("Open #random") }
    }
  }
}