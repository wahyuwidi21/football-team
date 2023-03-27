package com.made.footballteam.core.di

import com.made.footballteam.core.domain.usecase.FootballTeamInteractor
import com.made.footballteam.core.domain.usecase.FootballTeamUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun providefootBallTeamUseCase(footballTeamInteractor: FootballTeamInteractor): FootballTeamUseCase
}