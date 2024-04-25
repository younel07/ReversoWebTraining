<%@ page import="entites.Client" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire</title>
    <link rel="stylesheet" href="css/Gestion.css">
</head>
<body>
<header>
    <div> <h1> Supprimer ce client </h1> </div>
    <div>
        <p>
            <img class="logo_Reverso_Small" src="images/reverso.png" height="50"
                 alt="Formulaire Reverso logo"
                 title="small company logo">
        </p>
    </div>
</header>

<main>
    <article id="formId" class="form">
        <section id="labeslId" class="labels">
            <form action="SupprimerCient" method="post">
                <%
                    Client client = (Client) request.getAttribute("client");
                %>
                <div id="idId">
                    <label for="client">ID:</label>
                    <input type="text" id="client" class="text-field" name="id" value="<%=client.getId()%>" disabled>
                </div>
                <div id="raisonSocialId">
                    <label for="raison-social">Raison Social:</label>
                    <input type="text" id="raison-social" class="text-field" name="raison_social" value="<%=client.getRaisonSociale()%>" >
                </div>
                <div id="numeroRueId">
                    <label for="numero-rue">Numéro de la rue:</label>
                    <input type="text" id="numero-rue" class="text-field" name="numero_rue" value="<%=client.getNumRue()%>" disabled>
                </div>
                <div id="nomRueId">
                    <label for="nom-rue">Nom de la rue:</label>
                    <input type="text" id="nom-rue" class="text-field" name="nom_rue" value="<%=client.getNomRue()%>" disabled>
                </div>
                <div id="codePostalId">
                    <label for="code-postal">Code postal:</label>
                    <input type="text" id="code-postal" class="text-field" name="code_postal" value="<%=client.getCdPostal()%>" disabled>
                </div>
                <div id="villeId">
                    <label for="ville">Ville:</label>
                    <input type="text" id="ville" class="text-field" name="ville" value="<%=client.getVille()%>" disabled>
                </div>
                <div id="telephoneId">
                    <label for="telephone">Téléphone:</label>
                    <input type="text" id="telephone" class="text-field" name="telephone" value="<%=client.getTelephone()%>" disabled>
                </div>
                <div id="mailId">
                    <label for="mail">Mail:</label>
                    <input type="email" id="mail" class="text-field" name="mail" value="<%=client.getMail()%>" disabled>
                </div>
                <div id="commentairesId">
                    <label for="commentaires">Commentaires:</label>
                    <textarea id="commentaires" class="text-field" name="commentaires" rows="4" value="<%=client.getCommentaire()%>" disabled></textarea>
                </div>
                <div id="chiffreAffairesId">
                    <label for="chiffre-affaires">Chiffre d'affaires:</label>
                    <input type="text" id="chiffre-affaires" class="text-field" name="chiffre_affaires" value="<%=client.getChiffreAffaire()%>" disabled>
                </div>
                <div id="nombreEmployesId">
                    <label for="nombre-employes">Nombre d'employés:</label>
                    <input type="text" id="nombre-employes" class="text-field" name="nombre_employes" value="<%=client.getNbrEmploye()%>" disabled>
                </div>
                <button id="validerModifClient" type="submit">valider</button> <!-- Added submit button -->
            </form>
        </section>
    </article>
</main>
<footer>
    <p>
        <img class="logo_Reverso_Small" src="images/reverso.png" height="50"
             alt="Formulaire Reverso logo"
             title="small company logo">
    </p>
</footer>
<script src="script/Accueil.js"></script>
</body>
</html>
