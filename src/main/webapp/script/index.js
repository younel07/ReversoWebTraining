var inscriptionBtn = document.getElementById("inscriptionBtn");
var connexionBtn = document.getElementById("connexionBtn")

// Ajout d'un écouteur d'événement au clic sur le bouton d'inscription
inscriptionBtn.addEventListener("click", function() {
    // Redirection vers la page d'inscription
    window.location.href = "inscription.jsp"; // Assurez-vous de remplacer "inscription.jsp" par le chemin correct vers votre page d'inscription
});

connexionBtn.addEventListener("click", function (){
   window.location.href = "accueil.jsp";
});