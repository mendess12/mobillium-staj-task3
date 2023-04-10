package com.example.mobilliumtask3.ikincigorev

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GorevIkiViewModel : ViewModel() {

    private var randomNumber = 0
    private var randomCharacter = 'A'
    val liveData = MutableLiveData<Char>()

    fun generateRandomNumber(){
        randomNumber = Random.nextInt(0,9)
    }

    fun generateRandomCharacter(){
        randomCharacter = ('A'..'Z').random()
        liveData.postValue(randomCharacter)
    }
    fun isCorrectGuess(guess : Int): Boolean{
        return guess == randomNumber
    }
}