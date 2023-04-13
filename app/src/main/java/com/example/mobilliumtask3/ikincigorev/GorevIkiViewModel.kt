package com.example.mobilliumtask3.ikincigorev

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GorevIkiViewModel : ViewModel() {

    var randomNumber = 0
    var selectNumber : Int ?= null
    val selectNumberLiveData = MutableLiveData<String>()
    private var randomCharacter = 'A'
    val liveData = MutableLiveData<Char>()

    fun generateRandomNumber(){
        randomNumber = Random.nextInt(0,9)
    }

    fun generateRandomCharacter(){
        randomCharacter = ('A'..'Z').random()
        liveData.postValue(randomCharacter)
    }
    fun isCorrectGuess(){
        if (selectNumber == randomNumber){
            selectNumberLiveData.postValue("win")
        }else{
            selectNumberLiveData.postValue("try again")
        }
    }
}