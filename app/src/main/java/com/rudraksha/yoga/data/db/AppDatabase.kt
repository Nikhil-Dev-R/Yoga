package com.rudraksha.yoga.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rudraksha.yoga.data.model.UserProfile
import com.rudraksha.yoga.data.model.YogaPose

@Database(entities = [UserProfile::class, YogaPose::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun yogaDao(): YogaDao
}
