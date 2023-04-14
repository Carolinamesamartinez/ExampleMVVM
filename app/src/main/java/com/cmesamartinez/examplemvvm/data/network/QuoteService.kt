package com.cmesamartinez.examplemvvm.data.network

import com.cmesamartinez.examplemvvm.core.RetrofitHelper
import com.cmesamartinez.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {
    // consumir ese retrofit gracias al retrofit -> y a la apiservice
    //devuelve una lista tipo quotemodel ( de todas las quotes)
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getQuotes():List<QuoteModel>{
       return withContext(Dispatchers.IO){
           val response =retrofit.create(QuoteApiClient::class.java).getAllQuotes()
           response.body()?: emptyList()
       }
       }
}