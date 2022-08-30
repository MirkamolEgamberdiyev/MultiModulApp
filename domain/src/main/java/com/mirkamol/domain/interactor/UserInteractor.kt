package com.mirkamol.domain.interactor

import com.mirkamol.domain.models.GithubUser
import com.mirkamol.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserInteractor @Inject constructor(private val userRepository: UserRepository) {

    fun getUsers(): Flow<Result<List<GithubUser>>> {
        return userRepository.getUsers()
            .map {
                Result.success(it)
            }.catch {
                emit(Result.failure(it))
            }.flowOn(Dispatchers.IO)

    }


}