package com.example.globalsphere.data.aggregator.di

import com.example.globalsphere.data.aggregator.repository.GlobalShereRepositoryImpl
import com.example.globalsphere.data.domain.repositories.GlobalSphereRepository
import com.example.globalsphere.datasources.remote.api.GlobalSphereApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Feb, 2/4/24
 * TIME        : 6:09 PM
 */

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun providesGlobalSphereRepository(
        api: GlobalSphereApiService
    ): GlobalSphereRepository =  GlobalShereRepositoryImpl(globalSphereApiService = api)
}