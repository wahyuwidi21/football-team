package com.made.footballteam.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.made.footballteam.core.data.source.local.entity.FootballTeamDetailEntity
import com.made.footballteam.core.data.source.local.entity.FootballTeamEntity

@Database(
    entities = [FootballTeamEntity::class, FootballTeamDetailEntity::class],
    version = 1,
    exportSchema = false
)
abstract class FootballTeamDatabase : RoomDatabase() {

    abstract fun footballTeamDao(): FootballTeamDao

    abstract fun footballTeamDetailDao(): FootballTeamDetailDao

}