package com.mirkamol.data.repository

import com.mirkamol.data.network.ApiService
import com.mirkamol.domain.models.GithubUser
import com.mirkamol.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiService: ApiService) : UserRepository {
    override fun getUsers(): Flow<List<GithubUser>> {
        return apiService.getUsers()

    }
}