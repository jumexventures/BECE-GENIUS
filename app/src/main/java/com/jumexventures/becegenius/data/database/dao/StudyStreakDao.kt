package com.jumexventures.becegenius.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jumexventures.becegenius.domain.models.StudyStreak
import kotlinx.coroutines.flow.Flow

@Dao
interface StudyStreakDao {
    @Insert
    suspend fun insertStreak(streak: StudyStreak): Long

    @Update
    suspend fun updateStreak(streak: StudyStreak)

    @Query("SELECT * FROM study_streaks WHERE studentProfileId = :studentId")
    fun getStreakByStudent(studentId: Long): Flow<StudyStreak?>

    @Query("SELECT * FROM study_streaks WHERE studentProfileId = :studentId")
    suspend fun getStreakByStudentSync(studentId: Long): StudyStreak?
}
