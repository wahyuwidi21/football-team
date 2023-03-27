package com.made.footballteam.core.data.source.remote.network

import com.made.footballteam.core.data.source.remote.response.FootballTeamDetailResponse
import com.made.footballteam.core.data.source.remote.response.FootballTeamResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("v4/teams/")
    suspend fun getListTeam(
        @Query("limit") limit: Int = 10
    ): FootballTeamResponse

    @GET("v4/teams/{id}")
    suspend fun getDetailTeam(
        @Path("id") id: Int
    ): FootballTeamDetailResponse
}
