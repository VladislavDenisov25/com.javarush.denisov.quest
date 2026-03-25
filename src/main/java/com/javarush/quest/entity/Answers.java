package com.javarush.quest.entity;

public class Answers {

    Long id;
    String text;
    Long idNextQuestion;

    public Answers(Long id, String text, Long idNextQuestion) {
        this.id = id;
        this.text = text;
        this.idNextQuestion = idNextQuestion;
    }
}
