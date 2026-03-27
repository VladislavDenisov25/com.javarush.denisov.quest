package com.javarush.quest.controller;


import com.javarush.quest.entity.Answers;

import com.javarush.quest.entity.Question;
import com.javarush.quest.service.QuestionService;
import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "questionServlet", value = "/questionServlet")
public class QuestionServlet extends HttpServlet {


    private QuestionService questionService = new QuestionService();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        Long idQuestion = Long.parseLong(req.getParameter("idQuestion"));

        Question questionCurrent = questionService.getQuestion(idQuestion);
        String questionCurrentText = questionCurrent.getText();
        if (!questionCurrent.getIsFinish()) {
            Answers answerOne = questionCurrent.getAnswers()[0];
            Answers answerTwo = questionCurrent.getAnswers()[1];
            Long answerOneIdNextQuestion = answerOne.getIdNextQuestion();
            Long answerTwoIdNextQuestion = answerTwo.getIdNextQuestion();
            String answerOneText = answerOne.getText();
            String answerTwoText = answerTwo.getText();

            req.setAttribute("answerOneText", answerOneText);
            req.setAttribute("answerTwoText", answerTwoText);
            req.setAttribute("answerOneIdNextQuestion", answerOneIdNextQuestion);
            req.setAttribute("answerTwoIdNextQuestion", answerTwoIdNextQuestion);
            dispatcher = req.getRequestDispatcher("question.jsp");
        } else {
            dispatcher = req.getRequestDispatcher("finish.jsp");
        }
        req.setAttribute("questionText", questionCurrentText);

        dispatcher.forward(req, resp);
    }

}
