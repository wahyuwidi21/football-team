@file:Suppress("unused")

package com.made.footballteam.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class FootballTeamDetailResponse(

	@field:SerializedName("area")
	val area: Area? = null,

	@field:SerializedName("venue")
	val venue: String? = null,

	@field:SerializedName("website")
	val website: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("tla")
	val tla: String? = null,

	@field:SerializedName("founded")
	val founded: Int = -1,

	@field:SerializedName("marketValue")
	val marketValue: Int = -1,

	@field:SerializedName("lastUpdated")
	val lastUpdated: String? = null,

	@field:SerializedName("runningCompetitions")
	val runningCompetitions: List<RunningCompetitionsItem?>? = null,

	@field:SerializedName("clubColors")
	val clubColors: String? = null,

	@field:SerializedName("squad")
	val squad: List<SquadItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("shortName")
	val shortName: String? = null,

	@field:SerializedName("coach")
	val coach: Coach? = null,

	@field:SerializedName("crest")
	val crest: String? = null
)
@Suppress("unused")
data class RunningCompetitionsItem(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("emblem")
	val emblem: String? = null
)

@Suppress("unused")
data class Area(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("flag")
	val flag: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
@Suppress("unused")
data class Contract(

	@field:SerializedName("start")
	val start: String? = null,

	@field:SerializedName("until")
	val until: String? = null
)
@Suppress("unused")
data class SquadItem(

	@field:SerializedName("firstName")
	val firstName: String? = null,

	@field:SerializedName("lastName")
	val lastName: String? = null,

	@field:SerializedName("nationality")
	val nationality: String? = null,

	@field:SerializedName("shirtNumber")
	val shirtNumber: Int? = null,

	@field:SerializedName("contract")
	val contract: Contract? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("marketValue")
	val marketValue: Int? = null,

	@field:SerializedName("dateOfBirth")
	val dateOfBirth: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("position")
	val position: String? = null
)

@Suppress("unused")
data class Coach(

	@field:SerializedName("firstName")
	val firstName: String? = null,

	@field:SerializedName("lastName")
	val lastName: String? = null,

	@field:SerializedName("nationality")
	val nationality: String? = null,

	@field:SerializedName("contract")
	val contract: Contract? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("dateOfBirth")
	val dateOfBirth: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
