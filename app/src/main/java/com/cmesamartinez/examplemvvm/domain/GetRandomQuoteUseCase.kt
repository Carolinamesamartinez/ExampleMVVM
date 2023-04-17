package com.cmesamartinez.examplemvvm.domain

import com.cmesamartinez.examplemvvm.data.QuoteRepository
import com.cmesamartinez.examplemvvm.data.model.QuoteModel
import com.cmesamartinez.examplemvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteprovider:QuoteProvider){
    // esta no es la manera ideal
   // private val repository = QuoteRepository()
    // otra vez como es un caso de uso PERO ESTA EN MEMORIA ya que vamos DIRECTOS al provider
    operator fun invoke():QuoteModel?{
        //recogemos esas quote sdel provider
        val quotes=quoteprovider .quotes
        if(!quotes.isNullOrEmpty()){
            //generamos un random
            //returneamos
            val randomNumber=(quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}