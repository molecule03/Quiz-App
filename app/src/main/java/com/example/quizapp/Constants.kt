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
            "USA",
            "India",
            "Iran",
            "Isreal",
            2
        )

        val q2 = Questions(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Bhangi Pakistan",
            "India",
            "Greenland",
            1
        )

        val q3 = Questions(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Belgium",
            "Russia",
            "Bhangi Pakistan",
            "Holand",
            1
        )
        val q4 = Questions(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Columbia",
            "Nepal",
            "Argentina",
            "Holand",
            3
        )
        val q5 = Questions(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "USA",
            "Australia",
            "Germany",
            "Iraq",
            2
        )
        val q6 = Questions(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark ",
            "Russia",
            "Belgium",
            "Poland",
            1
        )
        val q7 = Questions(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Cananda",
            "Fiji",
            "Iceland",
            "England",
            2
        )
        val q8 = Questions(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "France",
            "Russia",
            "Ukraine",
            "Germany",
            4
        )
        val q9 = Questions(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "Afganisthan",
            "Saudi Arabia",
            "Egypt",
            1
        )
        val q10 = Questions(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "USA",
            "Taiwan",
            "England",
            "New Zealand",
            4
        )

        questionList.add(q1)
        questionList.add(q2);
        questionList.add(q3);
        questionList.add(q4);
        questionList.add(q5);
        questionList.add(q6);
        questionList.add(q7);
        questionList.add(q8);
        questionList.add(q9);
        questionList.add(q10);

        return questionList
    }

}