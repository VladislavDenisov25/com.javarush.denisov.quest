package com.javarush.quest.entity;

public class Questions {

    String text;
    Answers[] answers;
    Long id;
    Boolean isFinish;

    public Questions(String text, Answers[] answers, Long id, Boolean isFinish) {
        this.text = text;
        this.answers = answers;
        this.id = id;
        this.isFinish = isFinish;
    }
}
