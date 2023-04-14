package com.cmesamartinez.examplemvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.cmesamartinez.examplemvvm.databinding.ActivityMainBinding
import com.cmesamartinez.examplemvvm.ui.viewModel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // que se carge en memoria ( que nos devuelva cita) al abrir app
        quoteViewModel.onCreate()

        //mira si hay cambios en el quotemodel
        quoteViewModel.quoteModel.observe(this, Observer {currentQuote->
            binding.tvQuote.text=currentQuote.quote
            binding.tvAuthor.text=currentQuote.author
        })

        //mira si hay cambios en el quotemodel
        quoteViewModel.isLoading.observe(this, Observer { binding.progress.isVisible = it })

        // que nos la devuelve aletoriamente
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}