package com.made.footballteam.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "football_team_detail")
data class FootballTeamDetailEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "football_team_id")
    val id: Int,

    @ColumnInfo(name = "area")
    val area: String,

    @ColumnInfo(name = "venue")
    val venue: String,

    @ColumnInfo(name = "website")
    val website: String,

    @ColumnInfo(name = "address")
    val address: String,

    @ColumnInfo(name = "tla")
    val tla: String,

    @ColumnInfo(name = "founded")
    val founded: Int,

    @ColumnInfo(name = "market_value")
    val marketValue: Int,

    @ColumnInfo(name = "last_updated")
    val lastUpdated: String,

    @ColumnInfo(name = "running_competitions")
    val runningCompetitions: String,

    @ColumnInfo(name = "club_colors")
    val clubColors: String,

    @ColumnInfo(name = "squad")
    val squad: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "short_name")
    val shortName: String,

    @ColumnInfo(name = "coach")
    val coach: String,

    @ColumnInfo(name = "crest")
    val crest: String,

    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean
)