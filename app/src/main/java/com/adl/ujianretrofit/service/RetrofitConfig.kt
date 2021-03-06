package com.adl.ujianretrofit.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    fun getInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return okHttpClient


    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.2/cicool/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getLogin() = getRetrofit().create(ILogin::class.java)
    fun getAbsen()= getRetrofit().create(IAbsen::class.java)
    fun getDataAbsen()= getRetrofit().create(IAbsen::class.java)


}