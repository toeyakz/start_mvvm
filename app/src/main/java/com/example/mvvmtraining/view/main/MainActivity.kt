package com.example.mvvmtraining.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmtraining.R
import com.example.mvvmtraining.data.Constants
import com.example.mvvmtraining.databinding.ActivityMainBinding
import com.example.mvvmtraining.vo.enumClass.Status
import com.example.mvvmtraining.vo.model.body.BodyWeather
import com.example.mvvmtraining.vo.model.reponse.Hourly
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    private var mListDataOrderList = ArrayList<Hourly>()
    private val mAdapterWeatherList by lazy {
        AdapterWeatherList(binding.root.context, mListDataOrderList, viewModel.onClickItemOrderList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_main)*/

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initViewModel()

    }

    private fun onItemClickSeeWeather() {
        viewModel.onClickItemOrderList.observe(this, Observer {
            Log.d("MainActivity", it.temp.toString())
        })
    }

    private fun initViewModel() {
        loadDataWeather()
        initWeather()
        onItemClickSeeWeather()

        //viewModel.sendWeather.value =
    }

    private fun initWeather() {
        binding.rvWeather.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapterWeatherList
            mAdapterWeatherList.notifyDataSetChanged()
        }
    }

    private fun loadDataWeather() {

        viewModel.sendWeather.value =
            BodyWeather(0.0, 0.0, Constants.EXCLUDE, Constants.UNITS, Constants.API_KEY)


        viewModel.mResponseWeather.observe(this, Observer {
            binding.loadResource = it
            when (it.status) {
                Status.SUCCESS -> {
                    mListDataOrderList.addAll(it.data!!.hourly)
                    mAdapterWeatherList.notifyDataSetChanged()
                }
                Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }

            }

        })
    }
}