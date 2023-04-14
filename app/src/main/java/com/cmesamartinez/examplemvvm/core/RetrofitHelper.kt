package com.cmesamartinez.examplemvvm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
// 1 paso como vamos a tener datos de internet (de una api) pondremos un objeto que nos permita consumir de esta
    fun getRetrofit():Retrofit{
       return  Retrofit.Builder().baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}