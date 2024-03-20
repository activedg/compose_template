package com.example.template.feature.main

import androidx.compose.runtime.Immutable
import com.example.template.core.ui.base.BaseContract
import kotlinx.parcelize.Parcelize

@Parcelize
@Immutable
data class MainState(
    val count: Int = 0,
    val name: String = ""
) : BaseContract.State

sealed interface MainEvent : BaseContract.Event{
    data object OnClickAdd : MainEvent

    data class OnChangeName(val name: String) : MainEvent
}

sealed interface MainSideEffect : BaseContract.SideEffect{
}