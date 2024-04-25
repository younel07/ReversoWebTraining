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

@WebServlet(name = "ServletSuppressionClient", urlPatterns = "/SupprimerCient")
public class ServletSuppressionClient extends HttpServlet {
    private static Client client;
    private static Boolean test = false;

    @Override
    public void init() {
        test = false;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println(request.getParameter("raison_social"));





            if (!test || request.getParameter("raison_social")==null ) {

                HttpSession session = request.getSession();
                String selectedEntity = (String) session.getAttribute("deleteClient");


                client = DaoClient.findByNameClient(selectedEntity);

                request.setAttribute("client", client);
                request.getRequestDispatcher("suppressionClient.jsp").forward(request, response);
                test = true;
                System.out.println(test);

            }
            else {
                System.out.println("je pass ici 1 ");
                int id = client.getId();
                DaoClient.deletClient(id);
                System.out.println("je pass ici 1.5");
                test = false;
                response.sendRedirect("ListClient");

                System.out.println("je pass ici 2 ");
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