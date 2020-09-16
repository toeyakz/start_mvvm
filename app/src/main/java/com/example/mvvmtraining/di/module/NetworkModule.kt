package com.example.mvvmtraining.di.module

import com.example.mvvmtraining.data.rest.APIService
import com.example.mvvmtraining.data.rest.OkHttpClientBuilder
import com.example.mvvmtraining.data.rest.RetrofitBuilder
import org.koin.dsl.module

val netWorkModule = module {

    single { RetrofitBuilder }

    single<APIService> {
        get<RetrofitBuilder>().build(
            OkHttpClientBuilder.getUrlSever()
        )
    }
}