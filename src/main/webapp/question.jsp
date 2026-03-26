<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 26.03.2026
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Собеседование</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">

    <!-- Вопрос -->
    <h1>${questionText}</h1>

    <!-- Форма -->
    <form method="post" action="questionServlet" class="form-block">

        <!-- Вариант 1 -->
        <div>
            <input type="radio" name="idQuestion" value="${answerOneIdNextQuestion}" required>
            ${answerOneText}
        </div>

        <!-- Вариант 2 -->
        <div>
            <input type="radio" name="idQuestion" value="${answerTwoIdNextQuestion}">
            ${answerTwoText}
        </div>

        <!-- Кнопка -->
        <button type="submit">Ответить</button>

    </form>

</div>

</body>
</html>
