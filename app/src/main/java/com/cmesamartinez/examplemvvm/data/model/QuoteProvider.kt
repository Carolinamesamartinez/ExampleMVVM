package com.cmesamartinez.examplemvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteProvider @Inject constructor(){
    // el quote provider es una lista que almaccena los datos que se le pasan en memoria (tipoi quotemodel)

        var quotes:List<QuoteModel> = emptyList()


}