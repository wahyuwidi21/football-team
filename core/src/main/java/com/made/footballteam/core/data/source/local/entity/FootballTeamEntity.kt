package com.made.footballteam.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "football_team")
data class FootballTeamEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "football_team_id")
    val id: Int,

    @ColumnInfo(name = "venue")
    val venue: String,

    @ColumnInfo(name = "last_updated")
    val lastUpdated: String,

    @ColumnInfo(name = "website")
    val website: String,

    @ColumnInfo(name = "address")
    val address: String,

    @ColumnInfo(name = "club_colors")
    val clubColors: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "tla")
    val tla: String,

    @ColumnInfo(name = "founded")
    val founded: Int,

    @ColumnInfo(name = "short_name")
    val shortName: String,

    @ColumnInfo(name = "crest")
    val crest: String,
)