# Nix Dev Shell for Pushasaco

Reproducible **Android + Firebase** environment.

## Flakes
```bash
nix develop
# then
gradle :app:assembleDebug
```

## Legacy
```bash
nix-shell
```

### Tips
- If your nixpkgs lacks API 35, this flake uses API 34. Temporarily set `compileSdk = 34` or bump nixpkgs.
- Run `firebase login` in the shell before deploys.