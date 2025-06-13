package com.rudraksha.yoga.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.rudraksha.yoga.data.model.enums.YogaLevel
import com.rudraksha.yoga.data.model.enums.YogaLevelConverter

@Entity
@TypeConverters(YogaLevelConverter::class)
data class YogaPose(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val description: String,
    val benefits: String,
    val cautions: String,
    val level: YogaLevel,
    val imageResId: Int
)
