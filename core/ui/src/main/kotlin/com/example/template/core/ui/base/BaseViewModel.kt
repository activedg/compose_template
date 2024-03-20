package com.example.template.core.ui.base

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<S : BaseContract.State, E: BaseContract.Event, SE : BaseContract.SideEffect>(
    savedStateHandle: SavedStateHandle
): ContainerHost<S, SE>, ViewModel(){
    private val initialState by lazy {
        createInitialState()
    }
    protected abstract fun createInitialState(): S

    final override val container = container<S, SE>(
        initialState = initialState,
        savedStateHandle = savedStateHandle
    )

    val state : StateFlow<S> = container.stateFlow
    val sideEffect : Flow<SE> = container.sideEffectFlow

    private val _event: MutableSharedFlow<E> = MutableSharedFlow()

    private val _error: MutableSharedFlow<String> = MutableSharedFlow()
    val error: SharedFlow<String> = _error.asSharedFlow()

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _toast : MutableSharedFlow<String> = MutableSharedFlow()
    val toast : SharedFlow<String> = _toast.asSharedFlow()


    val ceh = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        setLoading(false)
        setError(throwable.message ?: "")
    }

    init {
        _event
            .onEach(::handleEvents)
            .launchIn(viewModelScope)
    }

    protected inline fun launch(
        coroutineContext: CoroutineContext = ceh,
        @ViewModelScoped crossinline action: suspend CoroutineScope.() -> Unit,
    ): Job {
        return viewModelScope.launch(coroutineContext) {
            action(this)
        }
    }

    protected fun launchWithLoading(
        coroutineContext: CoroutineContext = ceh,
        action: suspend CoroutineScope.() -> Unit,
    ): Job {
        return viewModelScope.launch(coroutineContext) {
            setLoading(true).join()
            action(this)
            setLoading(false).join()
        }
    }

    fun sendEvent(event: E) = viewModelScope.launch {
        _event.emit(event)
    }

    abstract fun handleEvents(event: E)

    protected fun setError(errorMsg: String) = viewModelScope.launch {
        _error.emit(errorMsg)
    }

    protected fun setLoading(isVisible: Boolean) = viewModelScope.launch {
        _isLoading.emit(isVisible)
    }

    protected fun sendToast(msg : String) = viewModelScope.launch {
        _toast.emit(msg)
    }
}