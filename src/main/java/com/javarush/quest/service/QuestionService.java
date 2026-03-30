package com.javarush.quest.service;

import com.javarush.quest.entity.Question;
import com.javarush.quest.repository.GameRepository;

public class QuestionService {

    private final GameRepository gameRepository;

    public QuestionService() {
        this.gameRepository = new GameRepository();
    }

    public Question getQuestion(Long idQuestion) {
        Question[] questions = gameRepository.getGame().getQuestions();

        for (Question question : questions) {
            if (question.getId().equals(idQuestion)) {
                return question;
            }
        }
        // не безопасно, сделал так из-за того что учебный проект
        throw new RuntimeException("Question not found: " + idQuestion);
    }
}