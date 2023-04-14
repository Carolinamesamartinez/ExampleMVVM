package com.cmesamartinez.examplemvvm.data.network

import com.cmesamartinez.examplemvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    // 2 paaso : conseguir esa info del json (o  que queremos guardar) devolviendo una lista tipo quotemodel
    @GET("/.json")
    suspend fun getAllQuotes():Response<List<QuoteModel>>

}