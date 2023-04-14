package com.cmesamartinez.examplemvvm.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmesamartinez.examplemvvm.data.model.QuoteModel
import com.cmesamartinez.examplemvvm.data.model.QuoteProvider
import com.cmesamartinez.examplemvvm.domain.GetQuotesUseCase
import com.cmesamartinez.examplemvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    val quoteModel= MutableLiveData<QuoteModel>()
    val isLoading= MutableLiveData<Boolean>()
    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCase=GetRandomQuoteUseCase()
    fun randomQuote(){
        isLoading.postValue(true)
        val quote=getRandomQuoteUseCase()
        if(quote!=null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)

    }

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result=getQuotesUseCase()
            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)

            }
        }
    }
}