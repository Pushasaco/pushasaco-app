# Pushasaco App — Android (Kotlin + Compose) + Firebase/GCP + AI (2025)

A modern starter for a **multilingual chat + crypto** Android app using **Jetpack Compose**, **Firebase** (Auth, Firestore, Storage, FCM, Remote Config, App Check), and optional **GCP** backends (Cloud Functions 2nd gen / Cloud Run). Designed to work in **VS Code** with the Android SDK (or Android Studio).

> This is a starter scaffold: add your **`google-services.json`** in `app/` and run. Crypto and AI modules are included as optional stubs you can enable progressively.

---

## Quick Start

### 0) Requirements
- JDK 17+
- Android SDK/NDK (via Android Studio or `sdkmanager`)
- VS Code (recommended) with the extensions listed in `.vscode/extensions.json`
- Node.js 20+ (for Firebase Functions)
- Firebase project created (enable Auth, Firestore, Storage, Remote Config, FCM, App Check)

### 1) Clone & open
```bash
unzip pushasaco-app.zip -d .   # (if you downloaded the zip)
cd pushasaco-app
code .
```

### 2) Android app setup
- Download your **`google-services.json`** from Firebase Console and place it at: `app/google-services.json`.
- In VS Code terminal:
```bash
./gradlew assembleDebug
./gradlew :app:installDebug
```
> If using Windows PowerShell, use `gradlew.bat`

### 3) Run locally
- Connect an Android device with USB debugging or launch an emulator.
- Hit **Run** in VS Code (or use `./gradlew :app:installDebug` then start the app).

### 4) Firebase Functions (optional)
```bash
cd backend/functions
npm i
npm run build
# Deploy when ready (requires Firebase CLI login + project set)
# firebase deploy --only functions
```

### 5) Configure Remote Config flags (optional)
Create `telemetry_enabled`, `crypto_enabled` booleans in Firebase Remote Config. App will read them at launch.

---

## What you get

- **Compose app** with MVVM + Hilt scaffolding
- **Localization** (`values/`, `values-pt/`, `values-es/`)
- **Realtime chat** repository stub using Firestore listeners
- **Push notifications** (FCM service stub)
- **Kill-switch flags** via Remote Config
- **Secure storage** with EncryptedSharedPreferences
- **Crypto module stubs** (EVM & BTC) to enable later
- **Cloud Functions v2 (TypeScript)** stub with an example message processor
- **Infra stubs** (Firestore rules/indexes, Terraform for later)
- **VS Code** tasks/launch + recommended extensions

---

## Project Layout

```
pushasaco-app/
  app/                       # Android app module (Kotlin, Compose)
  backend/
    functions/               # Firebase Functions v2 (TypeScript)
    cloudrun/                # Optional microservice skeleton
  infra/
    firestore.rules
    firestore.indexes.json
    terraform/               # Optional IaC stubs
  docs/
    architecture.md
  .vscode/                   # VS Code settings, tasks, launch
  build.gradle.kts
  settings.gradle.kts
  gradle.properties
  gradlew / gradlew.bat / gradle/wrapper/
```

---

## Notes

- The crypto code is **modularized and off by default**. Uncomment dependencies in `app/build.gradle.kts` and the calls in `WalletScreen.kt` once your RPCs and keys strategy are ready.
- **App Check**: Turn on Play Integrity provider in Firebase Console and enforce on Firestore/Storage/Functions to harden your backend.
- For a production path, consider **Cloud Run** microservices for wallet RPC proxying and price-feed caching, and **Firestore→BigQuery** streaming for analytics.

Happy building! 🚀
