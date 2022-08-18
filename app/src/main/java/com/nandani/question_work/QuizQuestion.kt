package com.nandani.question_work

data class QuizQuestions(var id:Int?=0, var question:String?=null,
                         var options: ArrayList<QuizQOptions>?= ArrayList(),
                         var correctIndex:Int?=null,
)


data class QuizQOptions(var options:String?= null)