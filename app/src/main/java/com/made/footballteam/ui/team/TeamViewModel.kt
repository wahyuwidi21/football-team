package com.made.footballteam.ui.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.made.footballteam.core.domain.usecase.FootballTeamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(footballTeamUseCase: FootballTeamUseCase) :
    ViewModel() {
    val footballTeam = footballTeamUseCase.getAllTeam().asLiveData()
}