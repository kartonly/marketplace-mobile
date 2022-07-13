package com.example.ugadayka

import com.example.ugadayka.API.API
import com.example.ugadayka.API.repo.GetRepository
import com.example.ugadayka.source.RemoteDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DependencyInjection {
    private val interceptor = HttpLoggingInterceptor().also {
        it.setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    private val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("http://marketplace.std-941.ist.mospolytech.ru/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(API::class.java)

    private val remoteData = RemoteDataSource()
    val repository = GetRepository(remoteData)

}