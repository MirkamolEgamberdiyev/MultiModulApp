package com.mirkamol.multimodulapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mirkamol.domain.interactor.UserInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userInteractor: UserInteractor) : ViewModel() {

    fun getUsers(): StateFlow<UserResource> {
        val stateFlow = MutableStateFlow<UserResource>(UserResource.Loading)
        viewModelScope.launch {
            userInteractor.getUsers()
                .catch {
                    stateFlow.emit(UserResource.Error(it.message ?: ""))
                }
                .collect {
                    if (it.isSuccess) {
                        stateFlow.emit(UserResource.Succes(it.getOrNull()))
                    } else if (it.isFailure) {
                        stateFlow.emit(UserResource.Error(it.getOrNull()?.toString()))
                    }

                }
        }

        return stateFlow

    }
}