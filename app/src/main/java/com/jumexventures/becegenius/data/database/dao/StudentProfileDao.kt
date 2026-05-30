package com.jumexventures.becegenius.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jumexventures.becegenius.domain.models.StudentProfile
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentProfileDao {
    @Insert
    suspend fun insertProfile(profile: StudentProfile): Long

    @Update
    suspend fun updateProfile(profile: StudentProfile)

    @Delete
    suspend fun deleteProfile(profile: StudentProfile)

    @Query("SELECT * FROM student_profiles WHERE id = :id")
    suspend fun getProfileById(id: Long): StudentProfile?

    @Query("SELECT * FROM student_profiles")
    fun getAllProfiles(): Flow<List<StudentProfile>>

    @Query("SELECT * FROM student_profiles ORDER BY lastActive DESC LIMIT 1")
    fun getLastActiveProfile(): Flow<StudentProfile?>

    @Query("UPDATE student_profiles SET lastActive = :timestamp WHERE id = :id")
    suspend fun updateLastActive(id: Long, timestamp: Long)
}
