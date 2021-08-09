package com.example.charadegame

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var word = ""
    var score = 0
    private lateinit var wordList: MutableList<String>

    private fun resetList(){
        wordList = mutableListOf(
            "Book","Phone","Clock","Cup","Knife","Bed","Candle","Table","Sand","Dentist","Wind-Mill","Party","Softball","Wig","Sheet","iPad","Taxi","Dog-house",
            "Wax","Ticket","Deodrants","Jeans","Spider-web","Spine","Chess","Eraser","Caravan","Volcano","Chalk","Flamingo","Shirts", "Tong","Mirror","Gym"
        )
        wordList.shuffle()
    }

    init{
        resetList()
        nextWord()
    }

    fun onSkip(){
        score--
        nextWord()
    }

    fun onCorrect(){
        score++
        nextWord()
    }

    private fun nextWord(){
        if(!wordList.isEmpty()){
            word = wordList.removeAt(0)
        }
    }
}