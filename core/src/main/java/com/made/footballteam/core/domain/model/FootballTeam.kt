package com.made.footballteam.core.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import kotlinx.parcelize.Parcelize

@Parcelize
data class FootballTeam(
    val id: Int,

    val venue: String,

    val lastUpdated: String,

    val website: String,

    val address: String,

    val clubColors: String,

    val name: String,

    val tla: String,

    val founded: Int,

    val shortName: String,

    val crest: String
):Parcelable