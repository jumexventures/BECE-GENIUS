package com.jumexventures.becegenius.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jumexventures.becegenius.data.database.dao.*
import com.jumexventures.becegenius.domain.models.*

@Database(
    entities = [
        StudentProfile::class,
        TestResult::class,
        Badge::class,
        StudyStreak::class,
        StudyNote::class,
        QuestionProgress::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateTypeConverter::class)
abstract class BeceGeniusDatabase : RoomDatabase() {
    abstract fun studentProfileDao(): StudentProfileDao
    abstract fun testResultDao(): TestResultDao
    abstract fun badgeDao(): BadgeDao
    abstract fun studyStreakDao(): StudyStreakDao
    abstract fun studyNoteDao(): StudyNoteDao
    abstract fun questionProgressDao(): QuestionProgressDao

    companion object {
        @Volatile
        private var INSTANCE: BeceGeniusDatabase? = null

        fun getInstance(context: Context): BeceGeniusDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    BeceGeniusDatabase::class.java,
                    "bece_genius_database"
                ).build().also { INSTANCE = it }
            }
    }
}
