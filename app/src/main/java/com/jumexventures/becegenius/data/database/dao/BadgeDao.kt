package com.jumexventures.becegenius.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jumexventures.becegenius.domain.models.Badge
import kotlinx.coroutines.flow.Flow

@Dao
interface BadgeDao {
    @Insert
    suspend fun insertBadge(badge: Badge): Long

    @Query("SELECT * FROM badges WHERE studentProfileId = :studentId")
    fun getBadgesByStudent(studentId: Long): Flow<List<Badge>>

    @Query("SELECT * FROM badges WHERE studentProfileId = :studentId AND badgeType = :badgeType")
    suspend fun getBadgeByType(studentId: Long, badgeType: String): Badge?

    @Query("SELECT COUNT(*) FROM badges WHERE studentProfileId = :studentId")
    fun getBadgeCount(studentId: Long): Flow<Int>
}
