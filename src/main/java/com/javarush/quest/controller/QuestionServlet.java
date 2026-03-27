package com.javarush.quest.controller;

import com.javarush.quest.entity.Question;
import com.javarush.quest.service.QuestionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;


@WebServlet(name = "questionServlet", value = "/questionServlet")
public class QuestionServlet extends HttpServlet {


    private QuestionService questionService = new QuestionService();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long idQuestion = Long.parseLong(req.getParameter("idQuestion"));
        Question questionCurrent = questionService.getQuestion(idQuestion);

        req.setAttribute("questionCurrent", questionCurrent);

        if (!questionCurrent.getIsFinish()) {
            req.getRequestDispatcher("question.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("finish.jsp").forward(req, resp);
        }
    }

}
