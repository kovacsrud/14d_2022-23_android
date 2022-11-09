package com.raz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PracticeViewModel:ViewModel() {
    var adatErtek=MutableLiveData<Int>()

    init {
        adatErtek.value=1;
    }
    fun Novel(){
        adatErtek.value=adatErtek.value?.plus(1)
    }
    fun Csokkent(){
        adatErtek.value=adatErtek.value?.minus(1)
    }

}