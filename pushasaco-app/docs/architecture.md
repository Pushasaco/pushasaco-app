# Architecture Overview

**Client (Android, Compose, MVVM + Hilt)**
- Multilingual UI (strings + on-device ML translate hook)
- Firestore realtime messages (snapshot listeners)
- Remote Config feature flags (telemetry & crypto kill-switch)
- EncryptedSharedPreferences for small secrets
- FCM push service stub

**Backend (Firebase/GCP)**
- Firestore: `/rooms/{roomId}/messages/{msgId}`
- Functions v2: onWrite processors (summaries, webhooks)
- Cloud Run microservices (optional): RPC proxy, price feed
- Infra stubs: Firestore Rules/Indexes, Terraform seeds