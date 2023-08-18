package com.example.globalsphere.di.modules

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * PROJECT NAME: GlobalSphere
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Aug, 8/9/23
 * TIME        : 10:29 PM
 */

private const val BASE_URL = "https://restcountries.com/v3.1/"
open class NetworkingCountry {

    val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
}
