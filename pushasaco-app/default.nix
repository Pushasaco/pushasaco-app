{ pkgs ? import <nixpkgs> { config = { android_sdk.accept_license = true; }; } }:
let
  android = pkgs.androidenv.composeAndroidPackages {
    platformVersions = [ "34" ];
    buildToolsVersions = [ "34.0.0" ];
    includeEmulator = false;
    includeNDK = false;
    useGoogleAPIs = true;
    acceptLicenses = true;
  };
in pkgs.mkShell {
  buildInputs = with pkgs; [
    jdk17_headless gradle_8 git nodejs_20 nodePackages.firebase-tools
    android.androidsdk android.platform-tools android.cmdline-tools
  ];
  ANDROID_HOME = android.androidsdk;
  ANDROID_SDK_ROOT = android.androidsdk;
  JAVA_HOME = pkgs.jdk17_headless;
}