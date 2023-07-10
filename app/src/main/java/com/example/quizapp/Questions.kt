package com.example.quizapp

/**
 * Data class representing a quiz question.
 *
 * @property id The unique identifier of the question.
 * @property question The text of the question.
 * @property image The resource ID of the image associated with the question.
 * @property optionFirst The text of the first option.
 * @property optionSecond The text of the second option.
 * @property optionThird The text of the third option.
 * @property optionFourth The text of the fourth option.
 * @property correctAns The index of the correct answer (1-based).
 */
data class Questions(
    val id: Int,
    val question: String,
    val image: Int,
    val optionFirst: String,
    val optionSecond: String,
    val optionThird: String,
    val optionFourth: String,
    val correctAns: Int
)
