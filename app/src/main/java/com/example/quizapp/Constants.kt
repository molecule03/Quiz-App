package com.example.quizapp

/**

Constants object that contains various constants used in the QuizApp.
 */
object Constants {

    /**

    Key for storing and retrieving the username in shared preferences.
     */
    const val userName: String = "username"
    /**

    Key for storing and retrieving the total number of questions in shared preferences.
     */
    const val totalQuestions: String = "totalQuestions"
    /**

    Key for storing and retrieving the number of correct answers in shared preferences.
     */
    const val correctAns: String = "correctAns"
    /**

    Function to retrieve a list of pre-defined quiz questions.

    @return ArrayList of Questions objects.
     */
    fun getQuestions(): ArrayList<Questions> {
        val questionList = ArrayList<Questions>()

// Define the quiz questions and their details
        val q1 = Questions(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "USA",
            "India",
            "Iran",
            "Israel",
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
            "Holland",
            1
        )

        val q4 = Questions(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Columbia",
            "Nepal",
            "Argentina",
            "Holland",
            3
        )

        val q5 = Questions(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "USA",
            "Australia",
            "Germany",
            "Iraq",
            2
        )

        val q6 = Questions(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Russia",
            "Belgium",
            "Poland",
            1
        )

        val q7 = Questions(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Canada",
            "Fiji",
            "Iceland",
            "England",
            2
        )

        val q8 = Questions(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "France",
            "Russia",
            "Ukraine",
            "Germany",
            4
        )

        val q9 = Questions(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "Afghanistan",
            "Saudi Arabia",
            "Egypt",
            1
        )

        val q10 = Questions(
            10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "USA",
            "Taiwan",
            "England",
            "New Zealand",
            4
        )

// Add the quiz questions to the questionList
        questionList.add(q1)
        questionList.add(q2)
        questionList.add(q3)
        questionList.add(q4)
        questionList.add(q5)
        questionList.add(q6)
        questionList.add(q7)
        questionList.add(q8)
        questionList.add(q9)
        questionList.add(q10)

        return questionList
    }
}