package com.example.mobilliumtask3.birincigorev

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GorevBirViewModel : ViewModel() {

    var count = 0
    val countLiveData = MutableLiveData<Int>()

    fun getCounter (){
        count ++
        countLiveData.value = count
    }
}