package com.made.footballteam.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FootballTeamDetail(

    val area: Area? = null,

    val venue: String? = null,

    val website: String? = null,

    val address: String? = null,

    val tla: String? = null,

    val founded: Int = -1,

    val marketValue: Int = -1,

    val lastUpdated: String? = null,

    val runningCompetitions: List<RunningCompetitionsItem?>? = null,

    val clubColors: String? = null,

    val squad: List<SquadItem?>? = null,

    val name: String? = null,

    val id: Int? = null,

    val shortName: String? = null,

    val coach: Coach? = null,

    val crest: String? = null,

    var isFavorite: Boolean? = false
) : Parcelable

@Parcelize
data class RunningCompetitionsItem(

    val code: String? = null,

    val name: String? = null,

    val id: Int? = null,

    val type: String? = null,

    val emblem: String? = null
) : Parcelable

@Parcelize
data class Area(

    val code: String? = null,

    val flag: String? = null,

    val name: String? = null,

    val id: Int? = null
) : Parcelable

@Parcelize
data class Contract(

    val start: String? = null,

    val until: String? = null
) : Parcelable

@Parcelize
data class SquadItem(

    val firstName: String? = null,

    val lastName: String? = null,

    val nationality: String? = null,

    val shirtNumber: Int? = null,

    val contract: Contract? = null,

    val name: String? = null,

    val marketValue: Int? = null,

    val dateOfBirth: String? = null,

    val id: Int? = null,

    val position: String? = null
) : Parcelable

@Parcelize
data class Coach(

    val firstName: String? = null,

    val lastName: String? = null,

    val nationality: String? = null,

    val contract: Contract? = null,

    val name: String? = null,

    val dateOfBirth: String? = null,

    val id: Int? = null
) : Parcelable


