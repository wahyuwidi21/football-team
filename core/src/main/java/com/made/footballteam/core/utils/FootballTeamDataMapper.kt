package com.made.footballteam.core.utils

import com.made.footballteam.core.data.source.local.entity.FootballTeamEntity
import com.made.footballteam.core.data.source.remote.response.FootballTeamResponse
import com.made.footballteam.core.domain.model.FootballTeam

object FootballTeamDataMapper {
    fun mapResponsesToEntities(input: FootballTeamResponse): List<FootballTeamEntity> {
        val teamList = ArrayList<FootballTeamEntity>()
        input.teams.map {
            val team = FootballTeamEntity(
                id = it.id,
                name = it.name,
                crest = it.crest,
                venue = it.venue,
                address = it.address,
                clubColors = it.clubColors,
                founded = it.founded,
                lastUpdated = it.lastUpdated,
                shortName = it.shortName,
                tla = it.tla,
                website = it.website
            )
            teamList.add(team)
        }
        return teamList
    }

    fun mapEntitiesToDomain(input: List<FootballTeamEntity>): List<FootballTeam> =
        input.map {
            FootballTeam(
                id = it.id,
                name = it.name,
                crest = it.crest,
                venue = it.venue,
                address = it.address,
                clubColors = it.clubColors,
                founded = it.founded,
                lastUpdated = it.lastUpdated,
                shortName = it.shortName,
                tla = it.tla,
                website = it.website
            )
        }

    fun mapDomainToEntity(input: FootballTeam) = FootballTeamEntity(
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
        website = input.website

    )
}