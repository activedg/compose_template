package com.example.template.feature.main

import androidx.lifecycle.SavedStateHandle
import com.example.template.core.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): BaseViewModel<MainState, MainEvent, MainSideEffect>(savedStateHandle){
    private fun increaseCount() = intent {
        reduce {
            state.copy(count = state.count + 1)
        }
    }

    private fun editName(name: String) = intent {
        reduce {
            state.copy(name = name)
        }
    }

    override fun createInitialState(): MainState {
        return MainState()
    }

    override fun handleEvents(event: MainEvent) {
        when(event){
            is MainEvent.OnClickAdd -> increaseCount()
            is MainEvent.OnChangeName -> editName(event.name)
        }
    }
}