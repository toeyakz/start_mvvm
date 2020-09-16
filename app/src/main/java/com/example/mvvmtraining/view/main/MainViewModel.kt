package com.example.mvvmtraining.view.main

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.mvvmtraining.data.rest.repository.GeneralRepository
import com.example.mvvmtraining.utils.SingleLiveData
import com.example.mvvmtraining.vo.model.body.BodyWeather
import com.example.mvvmtraining.vo.model.reponse.Hourly

class MainViewModel constructor(generalRepository: GeneralRepository) : ViewModel() {

    val onClickItemOrderList = SingleLiveData<Hourly>()

    val sendWeather = SingleLiveData<BodyWeather>()
    val mResponseWeather = Transformations.switchMap(sendWeather) {
        generalRepository.getListWeather(it)
    }

}