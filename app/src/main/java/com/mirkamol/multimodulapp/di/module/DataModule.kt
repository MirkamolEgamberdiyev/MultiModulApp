package com.mirkamol.multimodulapp.di.module

import com.mirkamol.data.network.ApiService
import com.mirkamol.data.repository.UserRepositoryImpl
import com.mirkamol.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [DataModule.BindModule::class])
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class BindModule {
        @Binds
        abstract fun bindApiRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
    }
}