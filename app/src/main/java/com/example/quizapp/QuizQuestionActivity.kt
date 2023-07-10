package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

/**
 * This activity displays the quiz questions and handles user interaction.
 */
class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    // Current position of the quiz question
    private var mCurrentPosition = 1

    // List of quiz questions
    private var mQuestionsList: ArrayList<Questions>? = null

    // Selected position by the user
    private var mSelectedPosition: Int = 0

    // Number of correct answers
    private var mCorrectAnswers: Int = 0

    // User name
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        // Get references to UI elements
        val tvOptionOne: TextView = findViewById(R.id.tv_option_one)
        val tvOptionTwo: TextView = findViewById(R.id.tv_option_two)
        val tvOptionThree: TextView = findViewById(R.id.tv_option_three)
        val tvOptionFour: TextView = findViewById(R.id.tv_option_four)
        val btnSubmit: Button = findViewById(R.id.btn_submit)

        // Get user name from the previous activity
        mUserName = intent.getStringExtra(Constants.userName)

        // Set up click listeners
        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

        // Set up the first question
        setQuestion()
    }

    override fun onClick(v: View?) {
        // Get references to UI elements
        val tvOptionOne: TextView = findViewById(R.id.tv_option_one)
        val tvOptionTwo: TextView = findViewById(R.id.tv_option_two)
        val tvOptionThree: TextView = findViewById(R.id.tv_option_three)
        val tvOptionFour: TextView = findViewById(R.id.tv_option_four)
        val btnSubmit: Button = findViewById(R.id.btn_submit)

        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tvOptionOne, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tvOptionTwo, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tvOptionThree, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tvOptionFour, 4)
            }
            R.id.btn_submit -> {
                if (mSelectedPosition == 0) {
                    // User has not selected an option, move to the next question
                    mCurrentPosition++
                    if (mCurrentPosition <= mQuestionsList!!.size) {
                        setQuestion()
                    } else {
                        // User has answered all questions, go to the result activity
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.userName, mUserName)
                        intent.putExtra(Constants.correctAns, mCorrectAnswers.toString())
                        intent.putExtra(Constants.totalQuestions, mQuestionsList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                } else {
                    // User has selected an option, check if it is correct
                    val question: Questions? = mQuestionsList!![mCurrentPosition - 1]
                    if (question!!.correctAns != mSelectedPosition) {
                        // User's answer is incorrect
                        answerView(mSelectedPosition, R.drawable.wrong_option_broder_bg)
                    } else {
                        // User's answer is correct
                        mCorrectAnswers++
                    }
                    answerView(question.correctAns, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        // Last question, change submit button text to "FINISH"
                        btnSubmit.text = "FINISH"
                    } else {
                        // Not the last question, change submit button text to "GO TO NEXT QUESTION"
                        btnSubmit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedPosition = 0
                }
            }
        }
    }

    private fun setQuestion() {
        // Get references to UI elements
        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        val tvProgress: TextView = findViewById(R.id.tv_progress)
        val tvQuestion: TextView = findViewById(R.id.tv_question)
        val ivImage: ImageView = findViewById(R.id.iv_image)
        val tvOptionOne: TextView = findViewById(R.id.tv_option_one)
        val tvOptionTwo: TextView = findViewById(R.id.tv_option_two)
        val tvOptionThree: TextView = findViewById(R.id.tv_option_three)
        val tvOptionFour: TextView = findViewById(R.id.tv_option_four)
        val btnSubmit: Button = findViewById(R.id.btn_submit)

        // Get the list of quiz questions
        mQuestionsList = Constants.getQuestions()

        // Get the current question
        val question: Questions? = mQuestionsList!![mCurrentPosition - 1]

        // Reset the UI to default state
        defaultOptionsView()

        // Update the submit button text based on the current question
        if (mCurrentPosition == mQuestionsList!!.size) {
            btnSubmit.text = "FINISH"
        } else {
            btnSubmit.text = "SUBMIT"
        }

        // Update UI elements with the current question data
        tvQuestion.text = question!!.question
        ivImage.setImageResource(question.image)
        progressBar.progress = mCurrentPosition
        tvProgress.maxEms = mQuestionsList!!.size
        tvProgress.text = "$mCurrentPosition / ${mQuestionsList!!.size}"
        tvOptionOne.text = question.optionFirst
        tvOptionTwo.text = question.optionSecond
        tvOptionThree.text = question.optionThird
        tvOptionFour.text = question.optionFourth
    }

    private fun answerView(answer: Int, drawableView: Int) {
        // Get references to UI elements
        val tvOptionOne: TextView = findViewById(R.id.tv_option_one)
        val tvOptionTwo: TextView = findViewById(R.id.tv_option_two)
        val tvOptionThree: TextView = findViewById(R.id.tv_option_three)
        val tvOptionFour: TextView = findViewById(R.id.tv_option_four)

        when (answer) {
            1 -> {
                tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tvOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tvOptionThree.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tvOptionFour.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun defaultOptionsView() {
        // Get references to UI elements
        val tvOptionOne: TextView = findViewById(R.id.tv_option_one)
        val tvOptionTwo: TextView = findViewById(R.id.tv_option_two)
        val tvOptionThree: TextView = findViewById(R.id.tv_option_three)
        val tvOptionFour: TextView = findViewById(R.id.tv_option_four)

        val options = ArrayList<TextView>()
        options.add(0, tvOptionOne)
        options.add(1, tvOptionTwo)
        options.add(2,tvOptionThree)
        options.add(3, tvOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        // Reset the UI to default state
        defaultOptionsView()

        // Highlight the selected option
        mSelectedPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
}
