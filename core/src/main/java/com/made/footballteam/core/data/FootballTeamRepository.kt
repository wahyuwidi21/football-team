package com.made.footballteam.core.data

import com.made.footballteam.core.data.source.local.LocalDataSource
import com.made.footballteam.core.data.source.remote.RemoteDataSource
import com.made.footballteam.core.data.source.remote.network.ApiResponse
import com.made.footballteam.core.data.source.remote.response.FootballTeamDetailResponse
import com.made.footballteam.core.data.source.remote.response.FootballTeamResponse
import com.made.footballteam.core.domain.model.FootballTeam
import com.made.footballteam.core.domain.model.FootballTeamDetail
import com.made.footballteam.core.domain.repository.IFootbalTeamRepository
import com.made.footballteam.core.utils.AppExecutors
import com.made.footballteam.core.utils.FootballTeamDataMapper
import com.made.footballteam.core.utils.FootballTeamDetailDataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FootballTeamRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IFootbalTeamRepository {

    override fun getAllTeam(): Flow<Resource<List<FootballTeam>>> =
        object : NetworkBoundResource<List<FootballTeam>, FootballTeamResponse>() {
            override fun loadFromDB(): Flow<List<FootballTeam>> {
                return localDataSource.getAllTeam().map {
                    FootballTeamDataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<FootballTeam>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<FootballTeamResponse>> =
                remoteDataSource.getAllTeam()

            override suspend fun saveCallResult(data: FootballTeamResponse) {
                val teamList = FootballTeamDataMapper.mapResponsesToEntities(data)
                localDataSource.insertTeam(teamList)
            }
        }.asFlow()

    override fun getTeamDetail(id:Int): Flow<Resource<FootballTeamDetail?>> =
        object : NetworkBoundResource<FootballTeamDetail?, FootballTeamDetailResponse>() {
            override fun loadFromDB(): Flow<FootballTeamDetail?> {
                return localDataSource.getTeamDetail(id).map {
                    FootballTeamDetailDataMapper.mapEntityToDomain(it)
                }
            }

            override fun shouldFetch(data: FootballTeamDetail?): Boolean =
               data == null

            override suspend fun createCall(): Flow<ApiResponse<FootballTeamDetailResponse>> = remoteDataSource.getDetailTeam(id)

            override suspend fun saveCallResult(data: FootballTeamDetailResponse) {
                val teamDetail = FootballTeamDetailDataMapper.mapResponsesToEntity(data)
                localDataSource.insertTeamDetail(teamDetail)
            }

        }.asFlow()

    override fun setFavoriteTeam(team: FootballTeamDetail, state: Boolean) {
        val teamEntity = FootballTeamDetailDataMapper.mapDomainToEntity(team)
        appExecutors.diskIO().execute {
               localDataSource.setFavoriteTeam(teamEntity, state)
        }
    }

    override fun getFavoriteTeam(id: Int): Flow<Boolean> {
        return localDataSource.getTeamFavorite(id)
    }

    override fun getAllFavoriteTeam(): Flow<List<FootballTeam>> = localDataSource.getAllTeamFavorite()
}

