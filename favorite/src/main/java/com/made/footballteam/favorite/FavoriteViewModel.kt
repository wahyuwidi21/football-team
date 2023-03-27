package com.made.footballteam.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.made.footballteam.core.domain.usecase.FootballTeamUseCase

class FavoriteViewModel(favoriteUseCase: FootballTeamUseCase) : ViewModel() {
    val footballTeam = favoriteUseCase.getAllFavoriteTeam().asLiveData()
}