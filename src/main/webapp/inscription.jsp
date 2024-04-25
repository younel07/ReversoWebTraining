<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25/04/2024
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang = "en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription</title>
    <link rel="stylesheet" href="css/inscription.css">

</head>
<body>
<header>
    <div> <h1> Inscription </h1> </div>
    <div>
        <p>
            <img class="logo_Reverso_Small" src="images/reverso.png" height="50"
                 alt="Accueil Reverso logo"
                 title="small company logo">
        </p>
    </div>
</header>
<main>
    <form action="inscription" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Register</button>
    </form>
</main>

<footer>
    <p>
        <img class="logo_Reverso_Small" src="images/reverso.png" height="50"
             alt="login Reverso logo"
             title="small company logo">
    </p>
</footer>
</body>
</html>