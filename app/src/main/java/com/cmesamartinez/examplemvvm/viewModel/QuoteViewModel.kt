package com.cmesamartinez.examplemvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cmesamartinez.examplemvvm.model.QuoteModel
import com.cmesamartinez.examplemvvm.model.QuoteProvider

class QuoteViewModel : ViewModel() {
    val quoteModel= MutableLiveData<QuoteModel>()

    fun randomQuote(){
        val currentQuote:QuoteModel=QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}