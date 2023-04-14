package com.cmesamartinez.examplemvvm.data

import com.cmesamartinez.examplemvvm.data.model.QuoteModel
import com.cmesamartinez.examplemvvm.data.model.QuoteProvider
import com.cmesamartinez.examplemvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response=api.getQuotes()
        QuoteProvider.quotes=response
        return response
    }
}