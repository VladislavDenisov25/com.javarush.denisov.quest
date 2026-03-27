<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 26.03.2026
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Вопрос</title>
    <link rel="stylesheet" href="сss/style.css">
</head>
<body>

<div class="container">

    <h1>${questionCurrent.text}</h1>

    <form method="post" action="questionServlet" class="form-block">

        <c:forEach var="answer" items="${questionCurrent.answers}">
            <label class="option">
                <input type="radio" name="idQuestion" value="${answer.idNextQuestion}" required>
                <span>${answer.text}</span>
            </label>
        </c:forEach>

        <c:if test="${!questionCurrent.isFinish}">
            <button type="submit">Ответить</button>
        </c:if>

        <c:if test="${questionCurrent.isFinish}">
            <button type="submit">Попробовать снова🫠</button>
            <input type="hidden" name="idQuestion" value="1">
        </c:if>
    </form>
    <br>
    <p>Статистика:</p>
   <p>Имя: ${sessionScope.name}</p>
   <p>Кол-во попыток: ${sessionScope.gamesCount}</p>
   <p>IP адрес: ${ip}</p>
</div>
</body>
</html>
