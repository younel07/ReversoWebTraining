<%@ page import="entites.Client" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: younes
  Date: 11/04/2024
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Affichage de liste</title>
    <link rel="stylesheet" href="css/AfficherListe.css">
</head>
<body>
<header>
    <div> <h1> Base de données </h1> </div>
    <div>
        <p>
            <img class="logo_Reverso_Small" src="images/reverso.png" height="50"
                 alt="Affichage BDD Reverso logo"
                 title="small company logo">
        </p>
    </div>
</header>
<main>
    <article id="EntitiesId" class="Entities">
        <div id="labelEntite">
            <label for="labelEntite"> Liste des clients</label>
        </div>
        <br/>
        <br/>
        <section id="tableId" class="table">
            <table id="entityTable">
                <thead>
                <tr>
                    <th>id</th>
                    <th>raison social</th>
                    <th>n° rue</th>
                    <th>nom rue</th>
                    <th>cd postal</th>
                    <th>ville</th>
                    <th>telephone</th>
                    <th>mail</th>
                    <th>chiffre d'affaire</th>
                    <th>nombre d'employés</th>
                    <th>comentaire</th>
                </tr>
                </thead>
                <tbody>
                <% for (Client client : (List<Client>) request.getAttribute("clients")) { %>
                <tr>
                    <td><%= client.getId() %></td>
                    <td><%= client.getRaisonSociale() %></td>
                    <td><%= client.getNumRue() %></td>
                    <td><%= client.getNomRue() %></td>
                    <td><%= client.getCdPostal() %></td>
                    <td><%= client.getVille() %></td>
                    <td><%= client.getTelephone() %></td>
                    <td><%= client.getMail() %></td>
                    <td><%= client.getChiffreAffaire() %></td>
                    <td><%= client.getNbrEmploye() %></td>
                    <td><%= client.getCommentaire() %></td>
                </tr>
                <% }%>
                </tbody>
            </table>
        </section>
        <section id="btnsId" class="btns">
            <div class="btnRetourId">
                <button id="retour">
                    Retour
                </button>
            </div>
            <div class="btnQuit">
                <button id="btnQuitId">
                    Quiter
                </button>
            </div>
        </section>
    </article>

</main>
<footer>
    <p>
        <img class="logo_Reverso_Small" src="images/reverso.png" height="50"
             alt="Affichage BDD Reverso logo"
             title="small company logo">
    </p>
</footer>
</body>
</html>