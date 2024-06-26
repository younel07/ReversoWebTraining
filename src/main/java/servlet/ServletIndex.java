package servlet;

import Dao.DaoUser;
import entites.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServletIndex", urlPatterns = "/login")
public class ServletIndex extends HttpServlet {

    @Override
    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les paramètres du formulaire
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            // Utiliser le DAO pour rechercher l'utilisateur par email
            User user = DaoUser.findByEmail(email);

            // Vérifier si l'utilisateur existe et si le mot de passe correspond
            if (user != null && user.getPassword().equals(password)) {
                // Authentification réussie
                // Rediriger l'utilisateur vers la page d'accueil par exemple
                response.sendRedirect("accueil");
            } else {
                // Authentification échouée
                // Rediriger l'utilisateur vers une page d'erreur ou de connexion
                response.sendRedirect("login");
            }
        } catch (Exception e) {
            // Gérer les exceptions ici (par exemple, renvoyer vers une page d'erreur)
            e.printStackTrace(); // À remplacer par la gestion appropriée des exceptions
            response.sendRedirect("login");
        }
    }

    @Override
    public void destroy() {

    }
}