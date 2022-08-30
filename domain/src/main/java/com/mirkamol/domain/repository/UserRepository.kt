package com.mirkamol.domain.repository

import com.mirkamol.domain.models.GithubUser
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface UserRepository {
     fun getUsers():Flow<List<GithubUser>>
}