package com.made.footballteam.core.di

import android.content.Context
import androidx.room.Room
import com.made.footballteam.core.data.source.local.room.FootballTeamDao
import com.made.footballteam.core.data.source.local.room.FootballTeamDatabase
import com.made.footballteam.core.data.source.local.room.FootballTeamDetailDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): FootballTeamDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("made-football-team".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            FootballTeamDatabase::class.java, "football-team.db"
        ).fallbackToDestructiveMigration().openHelperFactory(factory).build()
    }

    @Provides
    fun provideFootballTeamDao(database: FootballTeamDatabase): FootballTeamDao =
        database.footballTeamDao()

    @Provides
    fun provideFootballTeamDetailDao(database: FootballTeamDatabase): FootballTeamDetailDao =
        database.footballTeamDetailDao()
}