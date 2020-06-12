package com.example.quizzapp;


import com.google.firebase.firestore.DocumentId;

public class QuestionsModel {

    @DocumentId
    private String questionID;
    private String answer,option_a,option_b,option_c,question;
    private long timer;

    //Empty Constructor for FireBase
    public QuestionsModel(){

    }

    public QuestionsModel(String questionID, String answer, String option_a, String option_b, String option_c, String question, long timer) {
        this.questionID = questionID;
        this.answer = answer;
        this.option_a = option_a;
        this.option_b = option_b;
        this.option_c = option_c;
        this.question = question;
        this.timer = timer;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOption_a() {
        return option_a;
    }

    public void setOption_a(String option_a) {
        this.option_a = option_a;
    }

    public String getOption_b() {
        return option_b;
    }

    public void setOption_b(String option_b) {
        this.option_b = option_b;
    }

    public String getOption_c() {
        return option_c;
    }

    public void setOption_c(String option_c) {
        this.option_c = option_c;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }
}
