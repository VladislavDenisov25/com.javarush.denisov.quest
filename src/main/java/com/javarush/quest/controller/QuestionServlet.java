package com.javarush.quest.controller;

import com.javarush.quest.entity.Question;
import com.javarush.quest.service.QuestionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "questionServlet", value = "/questionServlet")
public class QuestionServlet extends HttpServlet {

    private final QuestionService questionService = new QuestionService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initSession(req);

        Long idQuestion = Long.parseLong(req.getParameter("idQuestion"));
        Question questionCurrent = questionService.getQuestion(idQuestion);

        req.setAttribute("questionCurrent", questionCurrent);
        req.setAttribute("ip", req.getRemoteAddr());

        if (questionCurrent.getIsFinish()){
            HttpSession session = req.getSession();

            Integer gamesCount = (Integer) session.getAttribute("gamesCount");
            session.setAttribute("gamesCount", gamesCount + 1);
        }
        req.getRequestDispatcher("question.jsp").forward(req, resp);
    }

    private void initSession(HttpServletRequest req) {
        HttpSession session = req.getSession();

        String name = req.getParameter("name");
        if (name != null && session.getAttribute("name") == null) {
            session.setAttribute("name", name);
        }

        if (session.getAttribute("gamesCount") == null) {
            session.setAttribute("gamesCount", 0);
        }
    }
}


