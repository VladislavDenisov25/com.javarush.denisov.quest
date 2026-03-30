package com.javarush.quest.service;

import com.javarush.quest.entity.Question;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuestionServiceTest {

    private final QuestionService questionService = new QuestionService();

    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3, 4, 5})
    public void shouldReturnCorrectQuestionById(Long idQuestion) {
        Question question = questionService.getQuestion(idQuestion);
        assertEquals(idQuestion, question.getId());
    }

    @ParameterizedTest
    @ValueSource(longs = {100, 1050})
    public void shouldThrowExceptionWhenQuestionNotFound(Long idQuestion) {
        assertThrows(RuntimeException.class, () -> questionService.getQuestion(idQuestion));
    }
}
