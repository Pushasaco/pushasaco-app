package com.pushasaco.core

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class PushService : FirebaseMessagingService() {
  override fun onNewToken(token: String) {
    // TODO: Save FCM token under /users/{uid}/devices
  }
  override fun onMessageReceived(message: RemoteMessage) {
    // TODO: Show local notification or in-app banner
  }
}