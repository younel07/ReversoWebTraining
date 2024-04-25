package servlet;

import Dao.DaoUser;
import entites.EntitiesException;
import entites.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServletInscription", urlPatterns = "/inscription")
public class ServletInscription extends HttpServlet {

    @Override
    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les paramètres du formulaire
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validation des données (à faire)

        // Créer un nouvel utilisateur
        User newUser = null;
        try {
            newUser = new User(username, email, password);
        } catch (EntitiesException e) {
            throw new RuntimeException(e);
        }

        try {
            // Utiliser le DAO pour créer l'utilisateur dans la base de données
            DaoUser.createUser(newUser);

            // Redirection vers une page de confirmation d'inscription
            response.sendRedirect("Accueil");
        } catch (Exception e) {
            // Gérer les exceptions ici (par exemple, renvoyer vers une page d'erreur)
            e.printStackTrace(); // À remplacer par la gestion appropriée des exceptions
            response.sendRedirect("login");//a gerer pour la page d'erreur
        }
    }


    @Override
    public void destroy() {

    }
}