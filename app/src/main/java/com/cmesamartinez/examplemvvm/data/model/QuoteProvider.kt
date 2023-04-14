package com.cmesamartinez.examplemvvm.data.model

class QuoteProvider {
    // el quote provider es una lista que almaccena los datos que se le pasan en memoria (tipoi quotemodel)
    companion object {
        var quotes:List<QuoteModel> = emptyList()

    }
}