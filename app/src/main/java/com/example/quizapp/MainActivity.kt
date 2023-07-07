package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN;

        var btn_start : Button = findViewById(R.id.btn_start)
        var et_name : AppCompatEditText= findViewById(R.id.et_name)
        btn_start.setOnClickListener {

            if(et_name.text.toString().isEmpty()) {
                Toast.makeText(this, "Aye Vedya... Naav taak", Toast.LENGTH_SHORT).show();

            }else{
                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(Constants.userName, et_name.text.toString());
                startActivity(intent)
                finish()
            }

        }
    }
}