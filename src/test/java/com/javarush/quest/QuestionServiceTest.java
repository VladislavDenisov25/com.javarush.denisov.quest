package com.javarush.quest;

import com.javarush.quest.entity.Question;
import com.javarush.quest.service.QuestionService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionServiceTest {

    private final QuestionService questionService = new QuestionService();

    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3, 4, 5})
    public void getCorrectQuestionForId(Long idQuestion){
        Question question = questionService.getQuestion(idQuestion);
        assertEquals(idQuestion, question.getId());
    }
}
