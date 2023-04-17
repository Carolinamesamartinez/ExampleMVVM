package com.cmesamartinez.examplemvvm.domain

import com.cmesamartinez.examplemvvm.data.QuoteRepository
import com.cmesamartinez.examplemvvm.data.database.entities.toDatabase
import com.cmesamartinez.examplemvvm.data.model.QuoteModel
import com.cmesamartinez.examplemvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor( private val repository : QuoteRepository){
    // esta es la manera idonea ir primero al repositorio
    //los casos de so son clases que hacen una sola acción , pero esto en ecorutinas (es lo que enviaremos a la view)
    // con el operator fun invoke esta clase será igual a repository.getallquotes


    suspend operator fun invoke():List<Quote>{
        val quotes=repository.getAllQuotesFromApi()
        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }

}