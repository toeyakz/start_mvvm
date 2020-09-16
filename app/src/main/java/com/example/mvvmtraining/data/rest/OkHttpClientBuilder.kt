package com.example.mvvmtraining.data.rest


import com.example.mvvmtraining.BuildConfig
import com.example.mvvmtraining.data.Constants
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object OkHttpClientBuilder {
    fun okHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            getHttpLoggingInterceptor()

        return OkHttpClient.Builder().addInterceptor {
            val original: Request = it.request()
            val request: Request = original.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .build()
            return@addInterceptor it.proceed(request)
        }.addInterceptor(interceptor)
            .connectTimeout(Constants.TIME_CONNECT, TimeUnit.SECONDS)
            .readTimeout(Constants.TIME_CONNECT, TimeUnit.SECONDS)
            .build()
    }

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor.Level {
        return if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
    }

    fun getUrlSever(): String {
        return BuildConfig.SERVER_URL
    }

}