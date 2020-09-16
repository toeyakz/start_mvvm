package com.example.mvvmtraining.view.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtraining.R
import com.example.mvvmtraining.databinding.ItemWeatherListBinding
import com.example.mvvmtraining.utils.SingleLiveData
import com.example.mvvmtraining.utils.setImageView
import com.example.mvvmtraining.vo.model.reponse.Hourly

class AdapterWeatherList(
    private var mContext: Context,
    private var mListWeather: ArrayList<Hourly>,
    private var mOnClickList: SingleLiveData<Hourly>
) : RecyclerView.Adapter<AdapterWeatherList.ViewHolder>() {

    override fun getItemCount(): Int {
        return mListWeather.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_weather_list, parent, false
        ) as ItemWeatherListBinding

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindText(holder, position)

        holder.binding.root.setOnClickListener {
            mOnClickList.value = mListWeather[position]
        }
    }


    private fun bindText(holder: ViewHolder, position: Int) {
        holder.binding.tvTime.text = mListWeather[position].dt.toString()
        holder.binding.tvCurrentTemperature.text = mListWeather[position].temp.toString()

        mContext.setImageView(holder.binding.ivWeather, mListWeather[position].weather[0].icon)
    }

    class ViewHolder(internal var binding: ItemWeatherListBinding) :
        RecyclerView.ViewHolder(binding.root)
}