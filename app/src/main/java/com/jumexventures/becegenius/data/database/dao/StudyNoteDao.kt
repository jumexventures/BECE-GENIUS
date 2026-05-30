package com.jumexventures.becegenius.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jumexventures.becegenius.domain.models.StudyNote
import kotlinx.coroutines.flow.Flow

@Dao
interface StudyNoteDao {
    @Insert
    suspend fun insertNote(note: StudyNote): Long

    @Update
    suspend fun updateNote(note: StudyNote)

    @Delete
    suspend fun deleteNote(note: StudyNote)

    @Query("SELECT * FROM study_notes WHERE studentProfileId = :studentId AND subject = :subject")
    fun getNotesByStudentAndSubject(studentId: Long, subject: String): Flow<List<StudyNote>>

    @Query("SELECT * FROM study_notes WHERE studentProfileId = :studentId")
    fun getNotesByStudent(studentId: Long): Flow<List<StudyNote>>

    @Query("SELECT * FROM study_notes WHERE studentProfileId = :studentId AND (title LIKE :query OR content LIKE :query)")
    fun searchNotes(studentId: Long, query: String): Flow<List<StudyNote>>

    @Query("SELECT * FROM study_notes WHERE studentProfileId = :studentId AND isBookmarked = 1")
    fun getBookmarkedNotes(studentId: Long): Flow<List<StudyNote>>
}
