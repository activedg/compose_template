package com.example.template.core.ui.base

import android.os.Parcelable

sealed interface BaseContract{
    interface State : BaseContract, Parcelable
    interface Event : BaseContract
    interface SideEffect : BaseContract
}