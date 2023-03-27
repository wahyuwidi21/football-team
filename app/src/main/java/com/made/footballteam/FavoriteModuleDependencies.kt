package com.made.footballteam

import com.made.footballteam.core.domain.usecase.FootballTeamUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {

    fun footballTeamUseCase(): FootballTeamUseCase
}