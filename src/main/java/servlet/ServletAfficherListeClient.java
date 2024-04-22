package servlet;

import Dao.DaoClient;
import entites.Client;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "affichageClient", urlPatterns = "/ListClient")

/*
    webservlet attributs
    name =  remplace le nom de la servlet par defaut
    description = donne une description
    urlPattern = specifie la ou les url disponible
    initParams = paramètre d'initialisation de la servlet
    et autres
 */

public class ServletAfficherListeClient extends HttpServlet {

    @Override
    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Client> clients = null;
        try {
            clients = DaoClient.findAllClient();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("clients", clients);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/afficherListeClient.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

    }
}