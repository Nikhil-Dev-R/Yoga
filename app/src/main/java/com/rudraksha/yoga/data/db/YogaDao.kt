package com.rudraksha.yoga.data.db

import androidx.room.*
import com.rudraksha.yoga.data.model.UserProfile
import com.rudraksha.yoga.data.model.YogaPose
import kotlinx.coroutines.flow.Flow

@Dao
interface YogaDao {

    // User Profile
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(profile: UserProfile)

    @Delete
    suspend fun deleteUser(profile: UserProfile)

    @Query("SELECT * FROM UserProfile")
    fun getAllProfiles(): Flow<List<UserProfile>>

    @Query("SELECT * FROM UserProfile WHERE id = :id")
    suspend fun getUserById(id: Int): UserProfile?

    // Yoga Poses
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertYogaPose(pose: YogaPose)

    @Query("SELECT * FROM YogaPose")
    fun getAllYogaPoses(): Flow<List<YogaPose>>

    @Query("SELECT * FROM YogaPose WHERE level = :level")
    suspend fun getYogaByLevel(level: String): List<YogaPose>
}
