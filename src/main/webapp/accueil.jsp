<%@ page import="java.util.ArrayList" %>
<%@ page import="entites.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="entites.Prospect" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/04/2024
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reverso Accueil</title>
    <link rel="stylesheet" href="css/Accueil.css">

</head>
<body>
<header>
    <div> <h1> Accueil </h1> </div>
    <div>
        <p>
            <img class="logo_Reverso_Small" src="images/reverso.png" height="50"
                 alt="Accueil Reverso logo"
                 title="small company logo">
        </p>
    </div>
</header>
<main>
    <table>
        <tr>
            <td><lable for="client-checkbox"> Client:</lable></td>
            <td><input type="radio" name="client-checkbox" id="client-checkbox" onchange="updateActions()" src="accueil"></td>

        </tr>
        <br/>

        <tr>
            <td><lable for="prospect-checkbox">Prospect:</lable></td>
            <td><input type="radio" name="client-checkbox" id="prospect-checkbox" onchange="updateActions()"></td>

        </tr>
    </table>
    <article>

        <section id="ComboBoxEntitesID" class="ComboBoxEntites">
            <select style="display: none" id="client-select" name="client">

                <option name="entite" id="client-combobox" value="">Choisir un client</option>
                <%
                    for (Client client : (List<Client>) request.getAttribute("clients")) {
                        String rs = client.getRaisonSociale();
                %>
                <option value="<%= rs %>"><%= rs%></option>
                <%
                    }
                %>

            </select >

            <select style="display: none" id="prospect-select" name="prospect">
                <option name="entite" id="prospect-combobox" value="">Choisir un prospect</option>
                <%
                    for (Prospect prospect : (List<Prospect>) request.getAttribute("prospects")) {
                        String rs = prospect.getRaisonSociale();
                %>
                <option value="<%= rs %>"><%= rs%></option>
                <%
                    }%>
            </select>
        </section>
        <!--section buttons-->
        <section id="ButtonsId" class="Bottons">
            <div class="btnAfficherBDD">
                <button id="btnAfficherBddId">
                    <a>Afficher la liste</a>
                </button>
            </div>
            <div class="btnNew">
                <button id="btnNewId">
                    <a>Nouveau</a>
                </button>
            </div>
            <div class="btnUpdate">
                <button id="btnUpdateId">
                    <a>Modifier</a>
                </button>
            </div>
            <div class="btnDelete">
                <button id="btnDeleteId">
                    <a>Supprimer</a>
                </button>
            </div>
            <div id="btnQuitId" class="btnQuit">
                <button id="btnQuit">
                    Quit
                </button>
            </div>

        </section>
    </article>
</main>
<footer>
    <p>
        <img class="logo_Reverso_Small" src="images/reverso.png" height="50"
             alt="login Reverso logo"
             title="small company logo">
    </p>
</footer>

<script src="script/Accueil.js"></script>
</body>
</html>
