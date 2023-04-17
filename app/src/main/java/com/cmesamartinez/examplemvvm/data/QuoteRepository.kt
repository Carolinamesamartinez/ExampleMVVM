package com.cmesamartinez.examplemvvm.data

import com.cmesamartinez.examplemvvm.data.model.QuoteModel
import com.cmesamartinez.examplemvvm.data.model.QuoteProvider
import com.cmesamartinez.examplemvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor( private val api : QuoteService,private val quoteProvider : QuoteProvider){
// instanciamos un objeto quoteservice ya que tendremos que tener esa lista de quotes


    suspend fun getAllQuotes():List<QuoteModel>{
        //el repositorio decidirá de donde sacar esas quotes si de memoria o internet
        // guardamos en la variable response la lista (getquotes)
        val response=api.getQuotes()
        // le decimos a la memoria que ahora las quotes del provider son las del response
        quoteProvider.quotes=response
        //return repuesta (returns quotes del provider)
        return response
        //ahora ya tenemos en una variabl más ,imia una lista de quotes
    }
}