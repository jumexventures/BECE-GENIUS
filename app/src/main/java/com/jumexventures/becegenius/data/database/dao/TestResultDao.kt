package com.jumexventures.becegenius.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jumexventures.becegenius.domain.models.TestResult
import kotlinx.coroutines.flow.Flow

@Dao
interface TestResultDao {
    @Insert
    suspend fun insertTestResult(result: TestResult): Long

    @Query("SELECT * FROM test_results WHERE studentProfileId = :studentId ORDER BY timestamp DESC")
    fun getTestResultsByStudent(studentId: Long): Flow<List<TestResult>>

    @Query("SELECT * FROM test_results WHERE studentProfileId = :studentId AND subject = :subject")
    fun getTestResultsByStudentAndSubject(studentId: Long, subject: String): Flow<List<TestResult>>

    @Query("SELECT AVG(score) FROM test_results WHERE studentProfileId = :studentId")
    fun getAverageScore(studentId: Long): Flow<Double?>

    @Query("SELECT MAX(score) FROM test_results WHERE studentProfileId = :studentId")
    fun getHighestScore(studentId: Long): Flow<Double?>

    @Query("SELECT MIN(score) FROM test_results WHERE studentProfileId = :studentId")
    fun getLowestScore(studentId: Long): Flow<Double?>

    @Query("SELECT COUNT(*) FROM test_results WHERE studentProfileId = :studentId")
    fun getTestCount(studentId: Long): Flow<Int>

    @Query("SELECT * FROM test_results WHERE id = :resultId")
    suspend fun getTestResult(resultId: Long): TestResult?
}
