package com.made.footballteam.core.data.source.local

import com.made.footballteam.core.data.source.local.entity.FootballTeamDetailEntity
import com.made.footballteam.core.data.source.local.entity.FootballTeamEntity
import com.made.footballteam.core.data.source.local.room.FootballTeamDao
import com.made.footballteam.core.data.source.local.room.FootballTeamDetailDao
import com.made.footballteam.core.domain.model.FootballTeam
import com.made.footballteam.core.utils.FootballTeamDataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val footballTeamDao: FootballTeamDao,
    private val footballTeamDetailDao: FootballTeamDetailDao
) {

    fun getAllTeam(): Flow<List<FootballTeamEntity>> = footballTeamDao.getAllTeam()

    suspend fun insertTeam(footballTeamList: List<FootballTeamEntity>) =
        footballTeamDao.insertTeam(footballTeamList)

    fun setFavoriteTeam(FootballTeamDetail: FootballTeamDetailEntity, newState: Boolean) {
        FootballTeamDetail.isFavorite = newState
        footballTeamDetailDao.updateFavoriteTeam(FootballTeamDetail)
    }

    fun getTeamDetail(id:Int): Flow<FootballTeamDetailEntity> = footballTeamDetailDao.getTeamDetail(id)

    fun getTeamFavorite(id:Int): Flow<Boolean> = footballTeamDetailDao.getTeamFavoriteStatus(id)

    fun getAllTeamFavorite(): Flow<List<FootballTeam>> = footballTeamDetailDao.getAllTeamFavorite()
        .map { FootballTeamDataMapper.mapEntitiesToDomain(it) }

    suspend fun insertTeamDetail(footballTeam: FootballTeamDetailEntity) =
        footballTeamDetailDao.insertTeamDetail(footballTeam)

}