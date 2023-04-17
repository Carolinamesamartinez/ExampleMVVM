package com.cmesamartinez.examplemvvm.data

import com.cmesamartinez.examplemvvm.data.database.entities.QuoteEntity
import com.cmesamartinez.examplemvvm.data.database.entities.dao.QuoteDao
import com.cmesamartinez.examplemvvm.data.model.QuoteModel
import com.cmesamartinez.examplemvvm.data.network.QuoteService
import com.cmesamartinez.examplemvvm.domain.model.Quote
import com.cmesamartinez.examplemvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor( private val api : QuoteService,private val quotedao:QuoteDao){
// instanciamos un objeto quoteservice ya que tendremos que tener esa lista de quotes


    suspend fun getAllQuotesFromApi():List<Quote>{
        //el repositorio decidirá de donde sacar esas quotes si de memoria o internet
        // guardamos en la variable response la lista (getquotes)
        val response:List<QuoteModel> =api.getQuotes()
        // le decimos a la memoria que ahora las quotes del provider son las del response
        //return repuesta (returns quotes del provider)
        return response.map{it.toDomain()}
        //ahora ya tenemos en una variabl más ,imia una lista de quotes
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response:List<QuoteEntity> = quotedao.getAllQuotes()
        return response.map{it.toDomain()}
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quotedao.insertAll(quotes)
    }

   suspend  fun clearQuotes() {
quotedao.deleteAllQuotes()        }
}