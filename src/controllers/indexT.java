package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.messageT;
import utils.DBUtilT;

/**
 * Servlet implementation class indexT
 */
@WebServlet("/index")
public class indexT extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexT() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = DBUtilT.createEntityManager();

        List<messageT> messages = em.createNamedQuery("getAllMessages", messageT.class)
                .getResultList();
        response.getWriter().append(Integer.valueOf(messages.size()).toString());

        em.close();
    }
}