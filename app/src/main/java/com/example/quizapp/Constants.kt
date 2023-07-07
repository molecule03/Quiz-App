package com.example.quizapp

object Constants {

    const val userName : String = "username";
    const val totalQuestions : String = "totalQuestions"
    const val correctAns : String = "correctAns";
    fun getQuestions(): ArrayList<Questions> {
        val questionList = ArrayList<Questions>();

        val q1 = Questions(
            1,
            "What country does this flag belong to?",
             R.drawable.ic_flag_of_india,
            "Bhangi Pakistan",
            "India",
            "Iran",
            "Isreal",
            2
        )

        val q2 = Questions(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "USA",
            "Bhangi Pakistan",
            "India",
            "Greenland",
            3
        )

        val q3 = Questions(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "India",
            "Russia",
            "Bhangi Pakistan",
            "Holand",
            1
        )
        questionList.add(q1)
        questionList.add(q2);
        questionList.add(q3);
        return questionList
    }

}