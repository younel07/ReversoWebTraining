package servlet;

import Dao.DaoClient;
import entites.Client;
import entites.EntitiesException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ServletModificationClient", urlPatterns = "/ModifierClient")
public class ServletModificationClient extends HttpServlet {
    private static Client client;
    private static Boolean test = false;

    @Override
    public void init() {
        test = false;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            System.out.println(request.getParameter("raison_social"));
            if (!test || request.getParameter("raison_social")==null ) {

                HttpSession session = request.getSession();
                String selectedEntity = (String) session.getAttribute("selectedEntity");


                client = DaoClient.findByNameClient(selectedEntity);

                request.setAttribute("client", client);
                request.getRequestDispatcher("modificationClient.jsp").forward(request, response);
                test = true;
            }else {
                System.out.println("je pass ici 1 ");
                String raisonSocial = request.getParameter("raison_social");
                String numRue = request.getParameter("numero_rue");
                String nomRue = request.getParameter("nom_rue");
                String cdPostal = request.getParameter("code_postal");
                String ville = request.getParameter("ville");
                String telephone = request.getParameter("telephone");
                String mail = request.getParameter("mail");
                double chiffreAffaires = Double.parseDouble(request.getParameter("chiffre_affaires"));
                int nbrEmployes = Integer.parseInt(request.getParameter("nombre_employes"));
                String commentaire = request.getParameter("commentaires");



                client.setRaisonSociale(raisonSocial);
                client.setNumRue(numRue);
                client.setNomRue(nomRue);
                client.setCdPostal(cdPostal);
                client.setVille(ville);
                client.setTelephone(telephone);
                client.setMail(mail);
                client.setChiffreAffaire(chiffreAffaires);
                client.setNbrEmploye(nbrEmployes);
                client.setCommentaire(commentaire);

                DaoClient.updateClient(client);

                response.sendRedirect("ListClient");
            test = false;
            }


            } catch (EntitiesException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void destroy() {

    }
}