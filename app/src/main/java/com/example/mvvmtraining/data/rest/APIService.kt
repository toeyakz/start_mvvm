package com.example.mvvmtraining.data.rest

import com.example.mvvmtraining.vo.model.reponse.ResponseWeather
import io.reactivex.Observable
import retrofit2.http.*
import java.util.*

interface APIService {

    @GET("onecall")
    fun getListWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude: String,
        @Query("units") units:String,
        @Query("appid") appid: String
    ): Observable<ResponseWeather>
}