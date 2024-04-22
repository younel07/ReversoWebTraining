package servlet;

import Dao.DaoClient;
import Dao.DaoProspect;
import entites.Client;
import entites.Prospect;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//anotation au lieu du mapping dans xml fichier
@WebServlet(name = "ServletAccueil", urlPatterns = {"/Accueil", "/accueil", "/choix"})
public class ServletAccueil extends HttpServlet {

    @Override
    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        List<Prospect> prospects = null;
        prospects = DaoProspect.findAllProspects();

        List<Client> clients = null;
        clients = DaoClient.findAllClient();

        request.setAttribute("clients", clients);

        request.setAttribute("prospects", prospects);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/accueil.jsp");
        dispatcher.forward(request, response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

    }
}