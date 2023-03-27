package com.made.footballteam.core.di

import com.made.footballteam.core.data.FootballTeamRepository
import com.made.footballteam.core.domain.repository.IFootbalTeamRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(footballTeamRepository: FootballTeamRepository): IFootbalTeamRepository

}