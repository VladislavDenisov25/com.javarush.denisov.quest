package com.javarush.quest.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class QuestionServletTest {

    @Test
    void CheckingTheCurrentQuestionParameterSetting() throws Exception{
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(req.getParameter("idQuestion")).thenReturn("1");
        when(req.getSession()).thenReturn(session);

        QuestionServlet servlet = new QuestionServlet();

        servlet.doPost(req, res);

        verify(req).setAttribute(eq("questionCurrent"), any());
    }
}
