import * as admin from "firebase-admin";
import { onDocumentCreated } from "firebase-functions/v2/firestore";

admin.initializeApp();

export const onMessageCreated = onDocumentCreated("rooms/{roomId}/messages/{msgId}", async (event) => {
  const snap = event.data;
  if (!snap) return;
  const data = snap.data();
  const text: string | undefined = data?.text;
  if (!text) return;

  // Example summary (stub): uppercase first 120 chars
  const summary = String(text).slice(0, 120).toUpperCase();

  await admin.firestore().doc(`rooms/${event.params.roomId}`)
    .set({ lastSummary: summary, updatedAt: admin.firestore.FieldValue.serverTimestamp() }, { merge: true });
});