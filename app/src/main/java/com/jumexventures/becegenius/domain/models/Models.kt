package com.jumexventures.becegenius.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "student_profiles")
data class StudentProfile(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val fullName: String,
    val studentClass: String, // JSS1, JSS2, JSS3
    val schoolName: String = "",
    val createdAt: Date = Date(),
    val lastActive: Long = System.currentTimeMillis()
)

@Entity(tableName = "test_results")
data class TestResult(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val studentProfileId: Long,
    val subject: String,
    val topic: String = "",
    val score: Double,
    val totalQuestions: Int,
    val correctAnswers: Int,
    val timestamp: Date = Date(),
    val testType: String, // PRACTICE or MOCK
    val duration: Long = 0 // in seconds
)

@Entity(tableName = "badges")
data class Badge(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val studentProfileId: Long,
    val badgeType: String,
    val badgeName: String,
    val description: String,
    val unlockedAt: Date = Date()
)

@Entity(tableName = "study_streaks")
data class StudyStreak(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val studentProfileId: Long,
    val currentStudyStreak: Int = 0,
    val longestStudyStreak: Int = 0,
    val lastStudyDate: Date? = null,
    val questionsAnsweredToday: Int = 0,
    val totalQuestionsAnswered: Int = 0
)

@Entity(tableName = "study_notes")
data class StudyNote(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val studentProfileId: Long,
    val subject: String,
    val topic: String,
    val title: String,
    val content: String,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val isBookmarked: Boolean = false
)

@Entity(tableName = "question_progress")
data class QuestionProgress(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val studentProfileId: Long,
    val questionId: String,
    val subject: String,
    val topic: String,
    val isAnswered: Boolean = false,
    val isCorrect: Boolean = false,
    val selectedAnswer: String = "",
    val lastAttempted: Date = Date()
)

data class Question(
    val id: String,
    val subject: String,
    val topic: String,
    val question: String,
    val options: List<String>,
    val answer: String,
    val explanation: String
)

data class PerformanceMetrics(
    val averageScore: Double = 0.0,
    val highestScore: Double = 0.0,
    val lowestScore: Double = 0.0,
    val totalTestsTaken: Int = 0,
    val totalQuestionsAnswered: Int = 0
)
