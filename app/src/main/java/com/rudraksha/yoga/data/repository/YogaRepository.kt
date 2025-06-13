package com.rudraksha.yoga.data.repository

import com.rudraksha.yoga.data.db.YogaDao
import com.rudraksha.yoga.data.model.UserProfile
import com.rudraksha.yoga.data.model.YogaPose
import com.rudraksha.yoga.data.model.enums.PhysicalLevel
import com.rudraksha.yoga.data.model.enums.YogaLevel
import kotlinx.coroutines.flow.Flow

class YogaRepository(private val dao: YogaDao) {

    fun getAllProfiles(): Flow<List<UserProfile>> = dao.getAllProfiles()

    suspend fun insertUser(user: UserProfile) = dao.insertUser(user)

    suspend fun deleteUser(user: UserProfile) = dao.deleteUser(user)

    suspend fun getUserById(id: Int): UserProfile? = dao.getUserById(id)

    fun getAllYogaPoses(): Flow<List<YogaPose>> = dao.getAllYogaPoses()

    suspend fun insertYogaPose(pose: YogaPose) = dao.insertYogaPose(pose)

    suspend fun getYogaByLevel(level: String): List<YogaPose> = dao.getYogaByLevel(level)

    /**
     * Suggest Yoga poses based on user physical activity level.
     */
    suspend fun suggestYogaForUser(user: UserProfile): List<YogaPose> {
        return when (user.physicalLevel) {
            PhysicalLevel.LOW -> dao.getYogaByLevel(YogaLevel.BEGINNER.name)
            PhysicalLevel.MEDIUM -> dao.getYogaByLevel(YogaLevel.INTERMEDIATE.name)
            PhysicalLevel.HIGH -> dao.getYogaByLevel(YogaLevel.ADVANCED.name)
        }
    }
}


