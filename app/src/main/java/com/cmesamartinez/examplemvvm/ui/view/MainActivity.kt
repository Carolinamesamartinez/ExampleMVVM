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

        quoteViewModel.onCreate()


        quoteViewModel.quoteModel.observe(this, Observer {currentQuote->
            binding.tvQuote.text=currentQuote.quote
            binding.tvAuthor.text=currentQuote.author
        })

        quoteViewModel.isLoading.observe(this, Observer { binding.progress.isVisible = it })

        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}