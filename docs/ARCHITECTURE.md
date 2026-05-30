# BECE Genius - Architecture Guide

## Overview

BECE Genius follows the **MVVM (Model-View-ViewModel) + Repository Pattern** with clean architecture principles.

## Architecture Layers

### 1. Data Layer

Responsible for data management and persistence.

```
data/
├── database/
│   ├── BeceGeniusDatabase.kt    # Room database instance
│   ├── DateTypeConverter.kt     # Type converters
│   └── dao/                     # Data Access Objects
│       ├── StudentProfileDao.kt
│       ├── TestResultDao.kt
│       ├── BadgeDao.kt
│       ├── StudyStreakDao.kt
│       ├── StudyNoteDao.kt
│       └── QuestionProgressDao.kt
├── local/
│   └── QuestionLoader.kt        # Load questions from JSON
└── repository/
    ├── StudentProfileRepository.kt
    ├── TestResultRepository.kt
    ├── BadgeRepository.kt
    ├── StudyStreakRepository.kt
    ├── StudyNoteRepository.kt
    └── QuestionRepository.kt
```

**Responsibilities:**
- Manage local database (Room)
- Load questions from JSON files
- Implement data persistence
- Abstract data sources

### 2. Domain Layer

Contains business logic and use cases.

```
domain/
├── models/
│   ├── StudentProfile.kt
│   ├── TestResult.kt
│   ├── Badge.kt
│   ├── StudyStreak.kt
│   ├── StudyNote.kt
│   ├── QuestionProgress.kt
│   ├── Question.kt
│   └── PerformanceMetrics.kt
└── usecases/
    ├── StudentProfileUseCase.kt
    ├── TestResultUseCase.kt
    ├── BadgeUseCase.kt
    ├── StudyStreakUseCase.kt
    ├── AnalyticsUseCase.kt
    └── QuestionUseCase.kt
```

**Responsibilities:**
- Define data models
- Implement business logic
- Use case orchestration
- Independent of frameworks

### 3. UI Layer

Handles presentation and user interaction.

```
ui/
├── screens/
│   ├── ProfileScreen.kt
│   ├── HomeScreen.kt
│   ├── SubjectScreen.kt
│   ├── PracticeScreen.kt
│   ├── MockExamScreen.kt
│   ├── AnalyticsScreen.kt
│   ├── NotesScreen.kt
│   ├── SettingsScreen.kt
│   └── LeaderboardScreen.kt
├── components/
│   ├── QuestionCard.kt
│   ├── ProgressBar.kt
│   ├── BadgeCard.kt
│   ├── StreakWidget.kt
│   └── ScoreChart.kt
├── viewmodels/
│   ├── HomeViewModel.kt
│   ├── PracticeViewModel.kt
│   ├── MockExamViewModel.kt
│   ├── AnalyticsViewModel.kt
│   ├── ProfileViewModel.kt
│   └── SettingsViewModel.kt
├── theme/
│   ├── Color.kt
│   ├── Type.kt
│   └── Theme.kt
└── navigation/
    └── Navigation.kt
```

**Responsibilities:**
- Display UI
- Handle user events
- Manage UI state via ViewModels
- Compose reusable components

### 4. Dependency Injection (Hilt)

```
di/
├── DatabaseModule.kt        # Provide database instance
├── RepositoryModule.kt      # Provide repositories
├── UseCaseModule.kt         # Provide use cases
└── ViewModelModule.kt       # Provide ViewModels
```

**Responsibilities:**
- Manage object creation
- Inject dependencies
- Configure scopes and lifecycles

## Data Flow

### Example: Getting Test Results

```
UI Layer (Screen)
    ↓
ViewModel (Manages State)
    ↓
UseCase (Business Logic)
    ↓
Repository (Abstraction)
    ↓
DAO (Database Access)
    ↓
Room Database (Local SQLite)
```

## State Management

Each ViewModel manages its own state using:

```kotlin
private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
val uiState: StateFlow<UiState> = _uiState.asStateFlow()
```

## Navigation

Navigation is handled using Jetpack Compose Navigation:

```
HomeScreen
    ↓ (navigate to subject)
SubjectScreen
    ↓ (navigate to practice)
PracticeScreen
    ↓ (navigate back)
HomeScreen
```

## Database Schema

### Tables:

1. **student_profiles** - Store student information
2. **test_results** - Store test scores and statistics
3. **badges** - Track earned achievements
4. **study_streaks** - Track study streaks
5. **study_notes** - Store user notes
6. **question_progress** - Track question history

## Offline Architecture

- All questions stored in JSON format in assets
- All data persisted locally using Room
- No network requests
- No external dependencies
- Complete functionality without internet

## Future Expansion

### Adding New Features:

1. Create model in `domain/models/`
2. Create DAO in `data/database/dao/`
3. Create entity and add to database
4. Create repository in `data/repository/`
5. Create use case in `domain/usecases/`
6. Create ViewModel in `ui/viewmodels/`
7. Create screen UI in `ui/screens/`
8. Add navigation

## Testing Strategy

### Unit Tests:
- Test repositories
- Test use cases
- Test ViewModels

### Integration Tests:
- Test DAO operations
- Test database interactions

### UI Tests:
- Test screen rendering
- Test user interactions

## Performance Considerations

1. **Database Indexing**: Add indexes on frequently queried columns
2. **Pagination**: Load large datasets in chunks
3. **Lazy Loading**: Load questions on demand
4. **Memory Management**: Use coroutines efficiently
5. **UI Rendering**: Use Compose's remember {} for optimization

## Security

- All data stored locally
- No sensitive data transmitted
- User data never leaves device
- Optional PIN protection for profiles
- Export/import with optional encryption

## Monitoring & Analytics

Internal tracking:
- Study streak updates
- Badge unlocks
- Test completions
- Performance improvements
- Feature usage

No external analytics or tracking.
