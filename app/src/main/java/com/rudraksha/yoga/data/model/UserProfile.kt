package com.rudraksha.yoga.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.rudraksha.yoga.data.model.enums.*

@Entity
@TypeConverters(GenderConverter::class, PhysicalLevelConverter::class, GoalConverter::class)
data class UserProfile(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val age: Int,
    val gender: Gender,
    val healthConditions: String,
    val physicalLevel: PhysicalLevel,
    val goals: Goal
)
