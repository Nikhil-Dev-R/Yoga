package com.rudraksha.yoga.data.model.enums

import androidx.room.TypeConverter

object GenderConverter {
    @TypeConverter fun fromGender(value: Gender): String = value.name
    @TypeConverter fun toGender(value: String): Gender = Gender.valueOf(value)
}

object PhysicalLevelConverter {
    @TypeConverter fun fromLevel(value: PhysicalLevel): String = value.name
    @TypeConverter fun toLevel(value: String): PhysicalLevel = PhysicalLevel.valueOf(value)
}

object GoalConverter {
    @TypeConverter fun fromGoal(value: Goal): String = value.name
    @TypeConverter fun toGoal(value: String): Goal = Goal.valueOf(value)
}

object YogaLevelConverter {
    @TypeConverter fun fromYogaLevel(value: YogaLevel): String = value.name
    @TypeConverter fun toYogaLevel(value: String): YogaLevel = YogaLevel.valueOf(value)
}
