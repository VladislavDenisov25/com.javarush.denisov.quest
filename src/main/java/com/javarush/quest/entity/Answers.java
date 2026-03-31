package com.javarush.quest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Answers {

    Long id;
    String text;
    Long idNextQuestion;
}
