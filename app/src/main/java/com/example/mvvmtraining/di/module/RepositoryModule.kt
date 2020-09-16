package com.example.mvvmtraining.di.module

import com.example.mvvmtraining.data.rest.repository.GeneralRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { GeneralRepository(get()) }

}