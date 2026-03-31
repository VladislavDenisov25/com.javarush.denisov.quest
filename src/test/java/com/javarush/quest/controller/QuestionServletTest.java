package com.javarush.quest.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.mockito.Mockito.*;

public class QuestionServletTest {

    @Test
    void checkingTheCurrentQuestionParameterSetting() throws Exception{
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);

        when(req.getParameter("idQuestion")).thenReturn("1");
        when(req.getSession()).thenReturn(session);
        when(req.getRequestDispatcher("question.jsp")).thenReturn(dispatcher);

        QuestionServlet servlet = new QuestionServlet();

        servlet.doPost(req, res);

        verify(req).setAttribute(eq("questionCurrent"), any());
    }

    @ParameterizedTest
    @ValueSource(longs = {8, 9})
    public void checkingTheGameCounterInSession(Long idQuestion) throws Exception{
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);

        when(req.getParameter("idQuestion")).thenReturn(idQuestion + "");
        when(req.getSession()).thenReturn(session);
        when(session.getAttribute("gamesCount")).thenReturn(0);
        when(req.getRequestDispatcher("question.jsp")).thenReturn(dispatcher);

        QuestionServlet servlet = new QuestionServlet();

        servlet.doPost(req, res);

        verify(session).setAttribute("gamesCount", 1);
    }
}
