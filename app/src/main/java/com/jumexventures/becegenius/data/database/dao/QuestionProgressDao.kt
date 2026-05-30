package com.jumexventures.becegenius.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jumexventures.becegenius.domain.models.QuestionProgress
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionProgressDao {
    @Insert
    suspend fun insertProgress(progress: QuestionProgress): Long

    @Update
    suspend fun updateProgress(progress: QuestionProgress)

    @Query("SELECT * FROM question_progress WHERE studentProfileId = :studentId AND questionId = :questionId")
    suspend fun getProgress(studentId: Long, questionId: String): QuestionProgress?

    @Query("SELECT * FROM question_progress WHERE studentProfileId = :studentId")
    fun getAllProgress(studentId: Long): Flow<List<QuestionProgress>>

    @Query("SELECT * FROM question_progress WHERE studentProfileId = :studentId AND subject = :subject")
    fun getProgressBySubject(studentId: Long, subject: String): Flow<List<QuestionProgress>>
}
