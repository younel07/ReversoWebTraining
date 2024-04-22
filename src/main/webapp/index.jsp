<!--a la place des vues no java here que d'html-->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reverso Login</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<main>
    <article>
        <div class="logoAvatar">
            <div class="logo" id="logoR">
                <p>
                    <img class="logo_Reverso_Big"
                         src="images/reverso.png" height="200"
                         alt="login Reverso logo"
                         title="company logo">
                </p>
            </div>
            <dr>
                <dr>
                    <div class="avatar" id="avatarID">
                        <img class="avatar" src="images/Rounded-31-512.webp"
                             height="100">
                    </div>
        </div>
        <div class="login_password">
            <div class="login">
                <input id = "email" class="Email_input" type="email"
                       placeholder="entrez votre Email"
                       autofocus="1" aria-label="Email">
            </div>
            <div class="passwordtxt" id="password">
                <input id="pass" class="password_input" type="password"
                       name="password" placeholder="Mot de passe"
                       aria-label="Mot de passe">
            </div>
        </div>
        <div>
            <!-- Bouton de connexion -->
            <button>
                <a href="accueil">Connexion</a>
            </button>
        </div>
    </article>
</main>
<footer>

</footer>

</body>
</html>