{
  description = "Pushasaco Android dev shell (VS Code + Android SDK + Firebase CLI)";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-24.05";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = import nixpkgs {
          inherit system;
          config = { android_sdk.accept_license = true; };
        };

        android = pkgs.androidenv.composeAndroidPackages {
          platformVersions = [ "34" ];
          buildToolsVersions = [ "34.0.0" ];
          includeEmulator = false;
          includeNDK = false;
          useGoogleAPIs = true;
          includeSources = false;
          acceptLicenses = true;
        };
      in {
        devShells.default = pkgs.mkShell {
          packages = with pkgs; [
            jdk17_headless
            gradle_8
            git
            nodejs_20
            nodePackages.firebase-tools
            android.androidsdk
            android.platform-tools
            android.cmdline-tools
          ];

          ANDROID_HOME = android.androidsdk;
          ANDROID_SDK_ROOT = android.androidsdk;
          JAVA_HOME = pkgs.jdk17_headless;
          GRADLE_OPTS = "-Dorg.gradle.jvmargs='-Xmx4g'";
        };
      });
}