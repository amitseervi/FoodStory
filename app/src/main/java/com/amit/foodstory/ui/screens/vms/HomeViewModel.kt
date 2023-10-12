package com.amit.foodstory.ui.screens.vms

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {

    private val viewModelState = MutableStateFlow<HomeViewModelState>(HomeViewModelState())
    val uiState: StateFlow<HomeUiState>
        get() = viewModelState.map {
            it.toUiState()
        }.stateIn(viewModelScope, SharingStarted.Eagerly, HomeUiState(0))

    private fun HomeViewModelState.toUiState(): HomeUiState {
        return HomeUiState(this.counterValue)
    }

    fun onCounterButtonClicked() {
        viewModelState.update { currentState ->
            currentState.copy(counterValue = currentState.counterValue + 1)
        }
    }
}

data class HomeUiState(val counterValue: Int)

data class HomeViewModelState(val counterValue: Int = 0)