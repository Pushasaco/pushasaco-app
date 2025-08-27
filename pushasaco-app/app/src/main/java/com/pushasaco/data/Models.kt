package com.pushasaco.data

data class Room(val id: String = "", val title: String = "", val participants: List<String> = emptyList())
data class Message(
  val id: String = "",
  val senderId: String = "",
  val text: String = "",
  val lang: String = "auto",
  val createdAt: com.google.firebase.Timestamp? = null
)