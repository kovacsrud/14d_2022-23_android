package com.raz.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PracticeViewModelFactory(private val ertek:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PracticeViewModel::class.java)){
            return PracticeViewModel(ertek) as T

        } else {
           throw java.lang.IllegalArgumentException("Nem megfelelő modell osztály!")
        }

    }
}