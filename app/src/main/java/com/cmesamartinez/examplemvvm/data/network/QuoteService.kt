package com.cmesamartinez.examplemvvm.data.network

import com.cmesamartinez.examplemvvm.core.RetrofitHelper
import com.cmesamartinez.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

// no odemos inyectar retrofit
class QuoteService @Inject constructor(private val api:QuoteApiClient){
    //en esta clase necesitamos el apicliente(@get) para consehuir también el retrofit pero como esta es una interfaz tendremos que meterla también con el retrofut en el modulo
    //para instancias especiales
    // consumir ese retrofit gracias al retrofit -> y a la apiservice
    //devuelve una lista tipo quotemodel ( de todas las quotes)

    suspend fun getQuotes():List<QuoteModel>{
       return withContext(Dispatchers.IO){
           val response =api.getAllQuotes()
           response.body()?: emptyList()
       }
       }
}