package com.made.footballteam.core.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.made.footballteam.core.data.source.local.entity.FootballTeamDetailEntity
import com.made.footballteam.core.data.source.remote.response.FootballTeamDetailResponse
import com.made.footballteam.core.domain.model.*

object FootballTeamDetailDataMapper {
    fun mapResponsesToEntity(input: FootballTeamDetailResponse): FootballTeamDetailEntity =
        FootballTeamDetailEntity(
            id = input.id,
            name = input.name.toString(),
            crest = input.crest.toString(),
            venue = input.venue.toString(),
            address = input.address.toString(),
            clubColors = input.clubColors.toString(),
            founded = input.founded,
            lastUpdated = input.lastUpdated.toString(),
            shortName = input.shortName.toString(),
            tla = input.tla.toString(),
            website = input.website.toString(),
            area = Gson().toJson(input.area),
            marketValue = input.marketValue,
            runningCompetitions = Gson().toJson(input.runningCompetitions),
            squad = Gson().toJson(input.squad),
            coach = Gson().toJson(input.coach),
            isFavorite = false
        )


    fun mapEntityToDomain(input: FootballTeamDetailEntity?): FootballTeamDetail? =

        if (input != null) FootballTeamDetail(
            id = input.id,
            name = input.name,
            crest = input.crest,
            venue = input.venue,
            address = input.address,
            clubColors = input.clubColors,
            founded = input.founded,
            lastUpdated = input.lastUpdated,
            shortName = input.shortName,
            tla = input.tla,
            website = input.website,
            isFavorite = input.isFavorite,
            area = Gson().fromJson(input.area, Area::class.java),
            marketValue = input.marketValue,
            runningCompetitions = Gson().fromJson(
                input.runningCompetitions,
                object : TypeToken<List<RunningCompetitionsItem>>() {}.type
            ),
            squad = Gson().fromJson(input.squad, object : TypeToken<List<SquadItem>>() {}.type),
            coach = Gson().fromJson(input.coach, Coach::class.java)
        ) else null


    fun mapDomainToEntity(input: FootballTeamDetail) =
        FootballTeamDetailEntity(
            id = input.id ?: 0,
            name = input.name.toString(),
            crest = input.crest.toString(),
            venue = input.venue.toString(),
            address = input.address.toString(),
            clubColors = input.clubColors.toString(),
            founded = input.founded,
            lastUpdated = input.lastUpdated.toString(),
            shortName = input.shortName.toString(),
            tla = input.tla.toString(),
            website = input.website.toString(),
            area = Gson().toJson(input.area),
            marketValue = input.marketValue,
            runningCompetitions = Gson().toJson(input.runningCompetitions),
            squad = Gson().toJson(input.squad),
            coach = Gson().toJson(input.coach),
            isFavorite = if (input.isFavorite == null) false else input.isFavorite!!
        )


}