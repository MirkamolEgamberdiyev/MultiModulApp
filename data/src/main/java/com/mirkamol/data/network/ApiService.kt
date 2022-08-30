package com.mirkamol.data.network

import com.mirkamol.domain.models.GithubUser
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {

    @GET("users")
     fun getUsers():Flow <List<GithubUser>>
}