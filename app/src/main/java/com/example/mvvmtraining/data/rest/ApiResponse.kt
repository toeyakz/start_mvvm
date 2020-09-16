package com.example.mvvmtraining.data.rest

import com.example.mvvmtraining.vo.model.reponse.ModelError
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

object ApiResponse {

    private val mGson = Gson()

    fun onErrorResponseServer(e: Throwable): String {
        val mMessageError: String

        mMessageError = when (e) {
            is retrofit2.HttpException -> {
                val responseBody = (e).response()!!.errorBody()
                val dataMessage = responseBody!!.string()
                DeserializeError(dataMessage)
            }
            else -> {
                e.message.toString()
            }
        }
        return mMessageError
    }

    private fun DeserializeError(errorString: String): String {
        return try {
            mGson.fromJson(errorString, ModelError::class.java).message
        } catch (e: JsonSyntaxException) {
            e.message.toString()
        }
    }
}