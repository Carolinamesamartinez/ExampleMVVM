package com.cmesamartinez.examplemvvm.domain

import com.cmesamartinez.examplemvvm.data.QuoteRepository
import com.cmesamartinez.examplemvvm.data.model.QuoteModel
import com.cmesamartinez.examplemvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository){
    // esta no es la manera ideal
   // private val repository = QuoteRepository()
    // otra vez como es un caso de uso PERO ESTA EN MEMORIA ya que vamos DIRECTOS al provider
    suspend operator fun invoke(): Quote?{
        //recogemos esas quote sdel provider
        val quotes=repository.getAllQuotesFromDatabase()
        if(!quotes.isNullOrEmpty()){
            //generamos un random
            //returneamos
            val randomNumber=(quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}