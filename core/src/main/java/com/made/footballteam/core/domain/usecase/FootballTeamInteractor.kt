package com.made.footballteam.core.domain.usecase

import com.made.footballteam.core.data.Resource
import com.made.footballteam.core.domain.model.FootballTeam
import com.made.footballteam.core.domain.model.FootballTeamDetail
import com.made.footballteam.core.domain.repository.IFootbalTeamRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FootballTeamInteractor @Inject constructor(private val footballTeamRepository: IFootbalTeamRepository) :
    FootballTeamUseCase {
    override fun getAllTeam(): Flow<Resource<List<FootballTeam>>> =
        footballTeamRepository.getAllTeam()

    override fun getTeamDetail(id: Int): Flow<Resource<FootballTeamDetail?>> =
        footballTeamRepository.getTeamDetail(id)

    override fun setFavoriteTeam(team: FootballTeamDetail, state: Boolean) =
        footballTeamRepository.setFavoriteTeam(team, state)

    override fun getFavoriteTeam(id: Int): Flow<Boolean> =
        footballTeamRepository.getFavoriteTeam(id)

    override fun getAllFavoriteTeam(): Flow<List<FootballTeam>> = footballTeamRepository.getAllFavoriteTeam()
}