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
    <title>Вопрос</title>
    <link rel="stylesheet" href="сss/style.css">
</head>
<body>

<div class="container">


    <h1>${questionText}</h1>


    <form method="post" action="questionServlet" class="form-block">

        <label class="option">
            <input type="radio" name="idQuestion" value="${answerOneIdNextQuestion}" required>
            <span>${answerOneText}</span>
        </label>

        <label class="option">
            <input type="radio" name="idQuestion" value="${answerTwoIdNextQuestion}">
            <span>${answerTwoText}</span>
        </label>

        <button type="submit">Ответить</button>

    </form>

</div>

</body>
</html>
