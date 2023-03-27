package com.made.footballteam.core.data.source.local.room

import androidx.room.*
import com.made.footballteam.core.data.source.local.entity.FootballTeamDetailEntity
import com.made.footballteam.core.data.source.local.entity.FootballTeamEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FootballTeamDetailDao {

    @Query("SELECT * FROM football_team_detail where football_team_id = :id")
    fun getTeamDetail(id: Int): Flow<FootballTeamDetailEntity>

    @Query("SELECT is_favorite FROM football_team_detail where football_team_id = :id")
    fun getTeamFavoriteStatus(id: Int): Flow<Boolean>

    @Query("SELECT * FROM football_team_detail where is_favorite = 1")
    fun getAllTeamFavorite(): Flow<List<FootballTeamEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeamDetail(teamDetail: FootballTeamDetailEntity)

    @Update
    fun updateFavoriteTeam(team: FootballTeamDetailEntity)
}
