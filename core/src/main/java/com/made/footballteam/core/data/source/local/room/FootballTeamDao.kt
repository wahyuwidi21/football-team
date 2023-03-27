package com.made.footballteam.core.data.source.local.room

import androidx.room.*
import com.made.footballteam.core.data.source.local.entity.FootballTeamEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FootballTeamDao {

    @Query("SELECT * FROM football_team")
    fun getAllTeam(): Flow<List<FootballTeamEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(team: List<FootballTeamEntity>)


}
