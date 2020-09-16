package com.example.mvvmtraining.data.rest.repository

import com.example.mvvmtraining.data.rest.APIService
import com.example.mvvmtraining.data.rest.NetworkBoundResource
import com.example.mvvmtraining.vo.model.body.BodyWeather
import com.example.mvvmtraining.vo.model.reponse.ResponseWeather

class GeneralRepository constructor(val apiService: APIService) {

    fun getListWeather(bodyWeather: BodyWeather) = object :
        NetworkBoundResource<ResponseWeather>() {
        override fun createCall() = apiService.getListWeather(
            bodyWeather.lat, bodyWeather.lon,
            bodyWeather.exclude, bodyWeather.units, bodyWeather.appid
        )
    }.asLiveData()

}