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

class QuizQuestionActivity : AppCompatActivity() , View.OnClickListener {



    private var  mCurrentPosition = 1;
    private var mQuestionsList : ArrayList<Questions>? = null;
    private var mSelectedPostion : Int = 0;
    private var mCorrectAns : Int = 0;
    private var mUserName : String? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        val tv_option_one : TextView = findViewById(R.id.tv_option_one);
        val tv_option_two : TextView = findViewById(R.id.tv_option_two);
        val tv_option_three : TextView = findViewById(R.id.tv_option_three);
        val tv_option_four : TextView = findViewById(R.id.tv_option_four);
        val btn_submit : Button = findViewById(R.id.btn_submit)

        mUserName = intent.getStringExtra(Constants.userName) ;

        setQuestion()

        tv_option_one.setOnClickListener(this);
        tv_option_two.setOnClickListener(this);
        tv_option_three.setOnClickListener(this);
        tv_option_four.setOnClickListener(this);
        btn_submit.setOnClickListener(this);
    }

    override fun onClick(v: View?) {

        var tv_option_one : TextView = findViewById(R.id.tv_option_one);
        var tv_option_two : TextView = findViewById(R.id.tv_option_two);
        var tv_option_three : TextView = findViewById(R.id.tv_option_three);
        var tv_option_four : TextView = findViewById(R.id.tv_option_four);
        val btn_submit : Button = findViewById(R.id.btn_submit)


        when(v?.id){
            R.id.tv_option_one ->{
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two ->{
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four ->{
                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit ->{
                if(mSelectedPostion == 0) {
                    mCurrentPosition++;
                    if(mCurrentPosition <= mQuestionsList!!.size ){
                        setQuestion()
                    }else{
                        val intent = Intent(this, ResultActivity::class.java)
                        startActivity(intent);
                        finish();
                    }
                }
                else{

                    val question: Questions? = mQuestionsList!![mCurrentPosition-1];
                    if(question!!.correctAns != mSelectedPostion) {
                        answerView(mSelectedPostion, R.drawable.wrong_option_broder_bg)
                    }else{
                        mCorrectAns++;
                    }
                    answerView(question!!.correctAns, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size) {
                        btn_submit.text = "FINISH";
                    }else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedPostion = 0;
                }
            }

        }
    }

    private fun setQuestion(){

        val progressBar : ProgressBar= findViewById(R.id.progressBar);
        val tv_progress : TextView = findViewById(R.id.tv_progress);
        val tv_question : TextView = findViewById(R.id.tv_question);
        val iv_image : ImageView = findViewById(R.id.iv_image);
        val tv_option_one : TextView = findViewById(R.id.tv_option_one);
        val tv_option_two : TextView = findViewById(R.id.tv_option_two);
        val tv_option_three : TextView = findViewById(R.id.tv_option_three);
        val tv_option_four : TextView = findViewById(R.id.tv_option_four);
        val btn_submit : Button = findViewById(R.id.btn_submit)


        mQuestionsList = Constants.getQuestions();
        val question: Questions? = mQuestionsList!![mCurrentPosition-1];

        defautOptionsView();

        if(mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }

        tv_question.text = question!!.question;
        iv_image.setImageResource(question!!.image);
        progressBar.progress = mCurrentPosition;

        tv_progress.text = "$mCurrentPosition / ${mQuestionsList!!.size}";
        tv_option_one.text = question!!.optionFirst
        tv_option_two.text = question!!.optionSecond
        tv_option_three.text = question!!.optionThird
        tv_option_four.text = question!!.optionFourth
    }




    private fun answerView(answer : Int, drawableView : Int){


        var tv_option_one : TextView = findViewById(R.id.tv_option_one);
        var tv_option_two : TextView = findViewById(R.id.tv_option_two);
        var tv_option_three : TextView = findViewById(R.id.tv_option_three);
        var tv_option_four : TextView = findViewById(R.id.tv_option_four);



        when(answer){
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4->{
                tv_option_four.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

        }

    }



    private fun defautOptionsView(){

        var tv_option_one : TextView = findViewById(R.id.tv_option_one);
        var tv_option_two : TextView = findViewById(R.id.tv_option_two);
        var tv_option_three : TextView = findViewById(R.id.tv_option_three);
        var tv_option_four : TextView = findViewById(R.id.tv_option_four);

        val options = ArrayList<TextView>();
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for(option in options){

            option.setTextColor(Color.parseColor("#7A8089"));
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )

        }
    }

    private fun selectedOptionView(tv : TextView, selectedOptionNum : Int){

        defautOptionsView()
        mSelectedPostion = selectedOptionNum;

        tv.setTextColor(Color.parseColor("#363A43"));
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }


}