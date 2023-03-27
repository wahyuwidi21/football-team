package com.made.footballteam.core.domain.repository

import com.made.footballteam.core.data.Resource
import com.made.footballteam.core.domain.model.FootballTeam
import com.made.footballteam.core.domain.model.FootballTeamDetail
import kotlinx.coroutines.flow.Flow

interface IFootbalTeamRepository {

    fun getAllTeam(): Flow<Resource<List<FootballTeam>>>

    fun getTeamDetail(id:Int):Flow<Resource<FootballTeamDetail?>>

    @Suppress("unused")
    fun setFavoriteTeam(team: FootballTeamDetail, state: Boolean)

    fun getFavoriteTeam(id:Int):Flow<Boolean>

    fun getAllFavoriteTeam(): Flow<List<FootballTeam>>

}