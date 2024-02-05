package com.example.globalsphere.datasources.remote.di

import com.example.globalsphere.datasources.remote.api.GlobalSphereApiImpl
import com.example.globalsphere.datasources.remote.api.GlobalSphereApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Feb, 2/4/24
 * TIME        : 2:57 PM
 */

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    fun providesHttpClient() = HttpClient(OkHttp){
        install(Logging){
            level = LogLevel.BODY
        }
        install(ContentNegotiation){
            json(Json{
                ignoreUnknownKeys = true
            })
        }
        install(DefaultRequest){
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
    }

    @Provides
    fun providesGlobalSphereApiService(
        client: HttpClient
    ): GlobalSphereApiService = GlobalSphereApiImpl(client = client)
}