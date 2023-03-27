package com.made.footballteam.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class FootballTeamResponse(

	@field:SerializedName("teams")
	val teams: List<TeamsItem>,

	@field:SerializedName("count")
	val count: Int,

	@field:SerializedName("filters")
	val filters: Filters
)

data class Filters(

	@field:SerializedName("offset")
	val offset: Int,

	@field:SerializedName("limit")
	val limit: Int,

	@field:SerializedName("permission")
	val permission: String
)

data class TeamsItem(

	@field:SerializedName("venue")
	val venue: String,

	@field:SerializedName("lastUpdated")
	val lastUpdated: String,

	@field:SerializedName("website")
	val website: String,

	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("clubColors")
	val clubColors: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("tla")
	val tla: String,

	@field:SerializedName("founded")
	val founded: Int,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("shortName")
	val shortName: String,

	@field:SerializedName("crest")
	val crest: String
)
