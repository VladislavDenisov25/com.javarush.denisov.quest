<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 27.03.2026
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Результат</title>
    <link rel="stylesheet" href="сss/style.css">
    <%@ page isELIgnored="false" %>
</head>
<body>
<div class="container">

    <h1>${questionText}</h1>
    <br>
    <div class="form-block">
        <form action="questionServlet" method="post">
            <input type="hidden" name="idQuestion" value="1">
            <br>
            <button type="submit">Попробовать с начала🫠</button>
        </form>
    </div>
</div>

</body>
</html>
