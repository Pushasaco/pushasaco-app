![pushasaco_more_fluid_progressive_slow (1)](https://github.com/user-attachments/assets/6b53d697-bd8b-41ce-ae95-660c7854d0b4)

# Pushasaco App — Android (Kotlin + Compose) + Firebase/GCP + AI (2025)

A modern starter for a **multilingual chat + crypto** Android app using **Jetpack Compose**, **Firebase** (Auth, Firestore, Storage, FCM, Remote Config, App Check), and optional **GCP** backends (Cloud Functions 2nd gen / Cloud Run). Works great in **VS Code** (Android SDK) or Android Studio.

> Add your **`google-services.json`** into `app/` and run. Crypto/AI are modular stubs you can enable progressively.

---

## Quick Start

### 0) Requirements
- JDK 17+
- Android SDK (cmdline tools + platform tools)
- VS Code (recommended) with the extensions in `.vscode/extensions.json` (or Android Studio)
- Node.js 20+ (for Firebase Functions)
- Firebase project created (Auth, Firestore, Storage, Remote Config, FCM, App Check)

### 1) Open & build
```bash
cd pushasaco-app
code .
# or open in Android Studio
```
- Put your **`google-services.json`** in `app/`.
- Build & install:
```bash
./gradlew :app:assembleDebug
./gradlew :app:installDebug
```

### 2) (Optional) Nix dev shell
If you use Nix, a reproducible dev shell is included.
```bash
nix develop   # flake
# or
nix-shell     # default.nix
```

### 3) Firebase Functions (optional)
```bash
cd backend/functions
npm i
npm run build
# firebase deploy --only functions
```

---

## Included

- **Compose + MVVM + Hilt** scaffold
- **Localization** (en/pt/es)
- **Firestore chat** repo with snapshot listeners
- **FCM** service stub
- **Remote Config** kill‑switch flags
- **EncryptedSharedPreferences** for secure local storage
- **Functions v2** sample (`onMessageCreated`)
- **Cloud Run** microservice skeleton
- **Infra** (Firestore rules/indexes, Terraform stub)
- **VS Code** tasks/launch
- **Nix** dev shell (flake + legacy)

> If your Nix channel lacks Android API 35, the flake pins API 34; you can either bump nixpkgs or temporarily set `compileSdk = 34`.
