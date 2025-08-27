package com.pushasaco.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class ChatRepository(
  private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
) {
  fun messages(roomId: String) = callbackFlow<List<Message>> {
    val reg = db.collection("rooms").document(roomId)
      .collection("messages")
      .orderBy("createdAt", Query.Direction.DESCENDING)
      .limit(100)
      .addSnapshotListener { snap, err ->
        if (err != null) { close(err); return@addSnapshotListener }
        trySend(snap!!.documents.mapNotNull { it.toObject(Message::class.java)?.copy(id = it.id) })
      }
    awaitClose { reg.remove() }
  }

  suspend fun send(roomId: String, msg: Message) {
    val roomRef = db.collection("rooms").document(roomId)
    db.runBatch { b ->
      val mref = roomRef.collection("messages").document()
      b.set(mref, msg.copy(id = mref.id, createdAt = com.google.firebase.Timestamp.now()))
      b.set(roomRef, mapOf("lastMessage" to msg.text, "updatedAt" to com.google.firebase.Timestamp.now()), com.google.firebase.firestore.SetOptions.merge())
    }.await()
  }
}