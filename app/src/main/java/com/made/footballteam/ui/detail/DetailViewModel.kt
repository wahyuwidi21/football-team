package com.made.footballteam.ui.detail

import androidx.lifecycle.*
import com.made.footballteam.core.domain.model.FootballTeamDetail
import com.made.footballteam.core.domain.usecase.FootballTeamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val footballTeamUseCase: FootballTeamUseCase) :
    ViewModel() {
    fun getTeamDetail(id: Int) = footballTeamUseCase.getTeamDetail(id).asLiveData()
    fun setFavoriteTeam(teamDetail: FootballTeamDetail, state: Boolean) =
        footballTeamUseCase.setFavoriteTeam(teamDetail, state)
}