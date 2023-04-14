package com.cmesamartinez.examplemvvm.data.model

import com.google.gson.annotations.SerializedName
// estructura con atributos de lo que qqueremos guardar
data class QuoteModel (@SerializedName("quote") val quote:String,@SerializedName("author") val author:String){
}