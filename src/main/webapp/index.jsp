<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Собеседование</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

<div class="container">

    <h1>Добро пожаловать на собеседование!</h1>

    <img class="picture" src="sobesedovanie.png" alt="Собеседование">

    <div class="content">
        <p>Ты являешься Java backend developer, тебя пригласили на собеседование с HR специалистом.</p>

        <p>После успешного прохождения собеседования с HR, тебе назначают техническое собеседование.</p>

        <p>А если оно окажется неудачным, то с тобой попрощаются. Твоя задача — успешно завершить текущее собеседование.</p>

        <p>Для этого честно отвечай на вопросы, не лги и говори уверенно! Желаю удачи!</p>
    </div>

    <div class="form-block">
        <form action="questionServlet" method="post">
            <label>Напомни свое имя?</label><br><br>
            <input type="text" name="name" placeholder="Введите имя" required>
            <input type="hidden" name="idQuestion" value="1">
            <br>
            <button type="submit">Начать</button>
        </form>
    </div>

</div>

</body>