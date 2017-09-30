package com.thomasnix.flashcards;

public class FlashCard {

    private String question;
    private String answer;

    FlashCard(String inQ, String inA){
        question = inQ;
        answer = inA;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
