package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tv_userName : TextView = findViewById(R.id.tv_userName)
        val tv_score : TextView = findViewById(R.id.tv_score);
        val btn_finish : Button = findViewById(R.id.btn_finish)


        tv_userName.text = intent.getStringExtra(Constants.userName);
        tv_score.text = "Your Score is ${intent.getStringExtra(Constants.correctAns)} out of ${
            intent.getStringExtra(Constants.totalQuestions)} ";

        btn_finish.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}