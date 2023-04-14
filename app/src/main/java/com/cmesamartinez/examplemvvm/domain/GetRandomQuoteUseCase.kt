package com.cmesamartinez.examplemvvm.domain

import com.cmesamartinez.examplemvvm.data.QuoteRepository
import com.cmesamartinez.examplemvvm.data.model.QuoteModel
import com.cmesamartinez.examplemvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    private val repository = QuoteRepository()
    operator fun invoke():QuoteModel?{
        val quotes=QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber=(quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}