package com.javarush.quest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Question {

    String text;
    Answers[] answers;
    Long id;
    Boolean isFinish;
}
