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

        // Hide the system UI (status bar and navigation bar) for a fullscreen experience
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        // Get references to the start button and name input field
        val btnStart: Button = findViewById(R.id.btn_start)
        val etName: AppCompatEditText = findViewById(R.id.et_name)

        // Set a click listener on the start button
        btnStart.setOnClickListener {
            // Check if the name input field is empty
            if (etName.text.toString().isEmpty()) {
                // Display a toast message to prompt the user to enter their name
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                // Create an intent to start the QuizQuestionActivity
                val intent = Intent(this, QuizQuestionActivity::class.java)
                // Pass the user's name as an extra to the QuizQuestionActivity
                intent.putExtra(Constants.userName, etName.text.toString())
                // Start the QuizQuestionActivity and finish the current activity
                startActivity(intent)
                finish()
            }
        }
    }
}
