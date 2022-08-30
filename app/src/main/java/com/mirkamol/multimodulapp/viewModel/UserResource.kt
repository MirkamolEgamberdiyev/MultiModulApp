package com.mirkamol.multimodulapp.viewModel

import com.mirkamol.domain.models.GithubUser

sealed class UserResource {
    object Loading : UserResource()
    data class Succes(val list: List<GithubUser>?) : UserResource()
    data class Error(val message: String?) : UserResource()

}