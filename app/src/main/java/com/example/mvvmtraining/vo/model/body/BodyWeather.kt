package com.example.mvvmtraining.vo.model.body

data class BodyWeather(
    val lat: Double,
    val lon: Double,
    val exclude: String,
    val units: String,
    val appid: String
)