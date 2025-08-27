package com.pushasaco.core

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import kotlinx.coroutines.tasks.await

object Flags {
  const val TELEMETRY_ENABLED = "telemetry_enabled"
  const val CRYPTO_ENABLED = "crypto_enabled"
}

class RemoteFlags(private val rc: FirebaseRemoteConfig) {
  suspend fun init() {
    rc.setConfigSettingsAsync(remoteConfigSettings {
      minimumFetchIntervalInSeconds = 3600
    }).await()
    rc.setDefaultsAsync(
      mapOf(Flags.TELEMETRY_ENABLED to true, Flags.CRYPTO_ENABLED to false)
    ).await()
    rc.fetchAndActivate().await()
  }
  fun telemetryOn() = rc.getBoolean(Flags.TELEMETRY_ENABLED)
  fun cryptoOn() = rc.getBoolean(Flags.CRYPTO_ENABLED)
}