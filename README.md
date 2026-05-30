# BECE Genius - Android Educational App

A comprehensive offline Android application designed to help Junior Secondary School (JSS) students prepare for the Basic Education Certificate Examination (BECE).

## Features

### 1. Multi-Student Profiles
- Create and manage multiple student profiles on the same device
- Switch between profiles seamlessly
- Profile customization: Name, Class (JSS1/JSS2/JSS3), School Name

### 2. Home Dashboard
- Personalized welcome message
- Study streak tracking
- Total tests and average scores
- Quick subject access
- Continue last practice option

### 3. 10 Core Subjects
- English Studies
- Mathematics
- Basic Science
- Basic Technology
- Social Studies
- Civic Education
- Computer Studies
- Business Studies
- CRS
- Yoruba

### 4. Practice Mode
- Topic-based practice questions
- Multiple choice (4 options)
- Instant answer feedback
- Detailed explanations
- Random question order
- Auto-save progress

### 5. Mock Exam Mode
- Simulates real BECE examinations
- Multi-subject selection
- Configurable timer
- Auto-submit on timeout
- Comprehensive results with corrections

### 6. Performance Analytics
- Average, highest, and lowest scores
- Subject and topic performance breakdown
- Questions answered tracking
- Progress statistics
- Best/weakest subjects identification

### 7. Smart Recommendations
- Automatic weak topic identification
- Personalized study plans
- Targeted practice suggestions

### 8. Study Streak System
- Consecutive study day tracking
- Daily question counter
- Streak display on dashboard

### 9. Achievement Badges
- First Practice Test
- First Mock Exam
- 7-Day & 30-Day Streaks
- 100 & 500 Questions Completed
- 90%+ Score Achievement
- Subject Master Badge

### 10. Local Leaderboard
- Compare scores between profiles on the same device
- Ranking system

### 11. Study Notes
- Offline notes for all subjects
- Topic organization
- Search functionality
- Bookmark system

### 12. Question Bank
- Thousands of questions in JSON format
- Topic and subject filtering
- Random selection algorithm

### 13. Customizable Settings
- Dark/Light mode
- Font size adjustment
- Progress reset option
- Progress export/import
- JSON question import

## Technical Stack

- **Language**: Kotlin
- **Architecture**: MVVM + Repository Pattern
- **Database**: Room (SQLite)
- **UI Framework**: Jetpack Compose / Material Design 3
- **Storage**: Local JSON files for question bank
- **Offline**: 100% offline functionality

## Project Structure

```
bece-genius/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/jumexventures/becegenius/
│   │   │   │   ├── data/
│   │   │   │   │   ├── database/
│   │   │   │   │   ├── local/
│   │   │   │   │   └── repository/
│   │   │   │   ├── domain/
│   │   │   │   │   ├── models/
│   │   │   │   │   └── usecases/
│   │   │   │   ├── ui/
│   │   │   │   │   ├── screens/
│   │   │   │   │   ├── components/
│   │   │   │   │   ├── theme/
│   │   │   │   │   └── viewmodels/
│   │   │   │   ├── di/
│   │   │   │   └── MainActivity.kt
│   │   │   ├── res/
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── build.gradle.kts
├── settings.gradle.kts
├── questions/
│   ├── mathematics.json
│   ├── english.json
│   ├── science.json
│   ├── technology.json
│   ├── social_studies.json
│   ├── civic.json
│   ├── computer_studies.json
│   ├── business_studies.json
│   ├── crs.json
│   └── yoruba.json
└── docs/
    ├── SETUP.md
    ├── ARCHITECTURE.md
    └── CONTRIBUTING.md
```

## Installation

1. Clone the repository
2. Open in Android Studio
3. Build and run on emulator or physical device
4. No internet required

## Usage

1. Create a student profile
2. Select a subject and practice
3. Take mock exams
4. Review analytics and recommendations
5. Track progress with streaks and badges

## Future Expansion

- WAEC preparation
- JAMB preparation
- Online sync (optional)
- Cloud backup

## License

Proprietary

## Support

For issues or suggestions, please create an issue in the repository.
