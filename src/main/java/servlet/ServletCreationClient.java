package servlet;

import Dao.DaoClient;
import entites.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServletGestionClient", urlPatterns = "/creationClient")
public class ServletCreationClient extends HttpServlet {

    @Override
    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("creationClient.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String raisonSocial = request.getParameter("raison_social");
        String numRue = request.getParameter("numero_rue");
        String nomRue = request.getParameter("nom_rue");
        String cdPostal = request.getParameter("code_postal");
        String ville = request.getParameter("ville");
        String telephone = request.getParameter("telephone");
        String mail = request.getParameter("mail");
        String chiffreAffairesStr = request.getParameter("chiffre_affaires");
        String nbrEmployesStr = request.getParameter("nombre_employes");
        String commentaire = request.getParameter("commentaires");

        double chiffreAffaires = Double.parseDouble(chiffreAffairesStr);
        int nbrEmployes = Integer.parseInt(nbrEmployesStr);

        try {
            Client client = new Client(1,raisonSocial,numRue,nomRue,cdPostal, ville,telephone,mail,
                    commentaire,chiffreAffaires,nbrEmployes);
            // Insert the new client into the database
            DaoClient.creatClient(client);

            // Redirect the user to a success page
            response.sendRedirect("ListClient");
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception appropriately
            // Redirect the user to an error page
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}