
package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

/**
 * This activity displays the quiz result with the user's score.
 */
class ResultActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Hide the status bar for a fullscreen experience
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        // Get references to UI elements
        val tvUserName: TextView = findViewById(R.id.tv_userName)
        val tvScore: TextView = findViewById(R.id.tv_score)
        val btnFinish: Button = findViewById(R.id.btn_finish)

        // Set the user name and score
        tvUserName.text = intent.getStringExtra(Constants.userName)
        tvScore.text =
            "Your Score is ${intent.getStringExtra(Constants.correctAns)} out of ${intent.getStringExtra(Constants.totalQuestions)}"

        // Set up click listener for the finish button
        btnFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
