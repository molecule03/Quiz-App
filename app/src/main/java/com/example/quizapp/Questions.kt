package com.example.quizapp

data class Questions(
    val id : Int,
    val question : String,
    val image : Int,
    val optionFirst : String,
    val optionSecond : String,
    val optionThird : String,
    val optionFourth : String,
    val correctAns : Int,
){

}

