package com.cmesamartinez.examplemvvm.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmesamartinez.examplemvvm.data.model.QuoteModel
import com.cmesamartinez.examplemvvm.domain.GetQuotesUseCase
import com.cmesamartinez.examplemvvm.domain.GetRandomQuoteUseCase
import com.cmesamartinez.examplemvvm.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase,
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
): ViewModel() {
    //el quotevidemodel es el intermediario entre la view y el model es decir entre la vusta y sus datos
    //por eso si pasa algo el mmutablelivedata porque notifica de esto
    val quoteModel= MutableLiveData<Quote>()
    val isLoading= MutableLiveData<Boolean>()
    //dos variables para instanciar clases

    fun randomQuote(){
        viewModelScope.launch {
            // cambiamos el estado del progressbar para darle feedback al usuario
            isLoading.postValue(true)
            //guaradmos en quote nuestra quote random
            val quote=getRandomQuoteUseCase()
            if(quote!=null){
                // cambiamos el valor del quotemmodel con postvalue
                quoteModel.postValue(quote)
            }
            //cambiamos estado del progressbar
            isLoading.postValue(false)

        }

    }

    fun onCreate() {
        //viewModelScope ecorutina automatica
        viewModelScope.launch {
            // cambiamos el estado del progressbar para darle feedback al usuario
            isLoading.postValue(true)
            //guaradmos en quote nuestras quotes
            val result=getQuotesUseCase()
            if(!result.isNullOrEmpty()){
                // cambiamos el estado del quote,model por la primera
                quoteModel.postValue(result[0])
                // cambiamos el estado del progressbar para darle feedback al usuario
                isLoading.postValue(false)

            }
        }
    }
}