package com.pushasaco.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import com.pushasaco.data.ChatRepository
import com.pushasaco.data.Message
import kotlinx.coroutines.launch

@Composable
fun MessagesScreen(roomId: String, onBack: () -> Unit) {
  val repo = remember { ChatRepository() }
  val scope = rememberCoroutineScope()
  var input by remember { mutableStateOf("") }
  var msgs by remember { mutableStateOf<List<Message>>(emptyList()) }

  LaunchedEffect(roomId) {
    repo.messages(roomId).collect { msgs = it }
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("#$roomId") },
        navigationIcon = { IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, contentDescription = "Back") } }
      )
    },
    bottomBar = {
      Row(Modifier.padding(8.dp)) {
        OutlinedTextField(
          value = input, onValueChange = { input = it },
          modifier = Modifier.weight(1f), placeholder = { Text("Type a message…") }
        )
        Spacer(Modifier.width(8.dp))
        Button(onClick = {
          if (input.isNotBlank()) {
            scope.launch {
              repo.send(roomId, Message(senderId = "demo", text = input))
              input = ""
            }
          }
        }) { Text("Send") }
      }
    }
  ) { pad ->
    LazyColumn(contentPadding = pad) {
      items(msgs) { m -> ListItem(headlineContent = { Text(m.text) }, supportingContent = { Text(m.senderId) }) }
    }
  }
}