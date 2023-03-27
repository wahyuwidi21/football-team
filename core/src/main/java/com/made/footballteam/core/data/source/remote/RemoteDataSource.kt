package com.made.footballteam.core.data.source.remote

import android.util.Log
import com.made.footballteam.core.data.source.remote.network.ApiResponse
import com.made.footballteam.core.data.source.remote.network.ApiService
import com.made.footballteam.core.data.source.remote.response.FootballTeamDetailResponse
import com.made.footballteam.core.data.source.remote.response.FootballTeamResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllTeam(): Flow<ApiResponse<FootballTeamResponse>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getListTeam()
                if (response.count != 0) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getDetailTeam(id:Int): Flow<ApiResponse<FootballTeamDetailResponse>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getDetailTeam(id)
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}

