# BECE Genius - Setup Guide

## Prerequisites

- Android Studio 2023.1 or later
- Android SDK 34 (API Level 34)
- Minimum SDK: Android 8.0 (API Level 26)
- Kotlin 1.9.20 or later
- JDK 17

## Installation Steps

### 1. Clone the Repository

```bash
git clone https://github.com/jumexventures/bece-genius.git
cd bece-genius
```

### 2. Open in Android Studio

1. Open Android Studio
2. Click "Open"
3. Navigate to the cloned directory
4. Click "OK"

### 3. Build the Project

1. Click "Build" → "Make Project"
2. Wait for the build to complete
3. Gradle will download all dependencies

### 4. Run the Application

#### On Android Emulator:
1. Click "AVD Manager"
2. Create or select a virtual device (Android 8.0 or higher)
3. Click "Run" → "Run 'app'"
4. Select the emulator
5. Click "OK"

#### On Physical Device:
1. Connect your Android device via USB
2. Enable USB Debugging on your device
3. Click "Run" → "Run 'app'"
4. Select your device
5. Click "OK"

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/jumexventures/becegenius/
│   │   │   ├── data/          # Data layer (DB, repositories)
│   │   │   ├── domain/        # Domain layer (models, use cases)
│   │   │   ├── ui/            # UI layer (screens, components)
│   │   │   ├── di/            # Dependency injection
│   │   │   └── MainActivity.kt
│   │   ├── res/               # Resources (layouts, drawables, etc.)
│   │   └── AndroidManifest.xml
│   └── test/                  # Unit tests
├── build.gradle.kts
└── proguard-rules.pro
```

## Adding Question Data

### Place JSON files in: `app/src/main/assets/questions/`

Example file: `mathematics.json`

```json
[
  {
    "id": "math_001",
    "subject": "Mathematics",
    "topic": "Algebra",
    "question": "If 2x = 10, find x.",
    "options": ["2", "4", "5", "10"],
    "answer": "5",
    "explanation": "Divide both sides by 2: x = 10/2 = 5"
  }
]
```

## Development Workflow

### Adding a New Feature

1. Create a new branch: `git checkout -b feature/feature-name`
2. Make your changes
3. Test thoroughly
4. Commit: `git commit -m "Add feature description"`
5. Push: `git push origin feature/feature-name`
6. Create a Pull Request

### Building a Release APK

1. Click "Build" → "Generate Signed Bundle/APK"
2. Select "APK"
3. Click "Next"
4. Create or select a keystore
5. Fill in the key details
6. Select "Release" build variant
7. Click "Finish"

The APK will be generated in `app/release/`

## Troubleshooting

### Gradle Sync Failed

- Click "File" → "Sync Now"
- If it persists, try "File" → "Invalidate Caches" → "Invalidate and Restart"

### Build Errors

- Ensure JDK 17 is selected: "File" → "Project Structure" → "SDK Location"
- Check that Android SDK 34 is installed
- Clear build cache: `./gradlew clean`

### Emulator Issues

- If the emulator is slow, enable GPU acceleration
- Allocate more RAM to the emulator (recommended: 4GB)

## Dependencies

Key libraries used:

- **Jetpack Compose**: Modern UI framework
- **Room**: Local database
- **Hilt**: Dependency injection
- **Navigation**: In-app navigation
- **Kotlin Serialization**: JSON parsing
- **DataStore**: Preferences storage

## Documentation

See `docs/ARCHITECTURE.md` for detailed architecture information.

## Support

For issues or questions, please open an issue on GitHub.
