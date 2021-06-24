/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 *
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package controller;

import dao.DigitalDAO;
import dao.impl.DigitalDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Digital;

/**
 * This class use DigitalDAO to get digital news by title then forward to
 * Search.jsp
 *
 * @author Xuan Duc
 */
public class SearchController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request the object of <code>HttpServletRequest</code>
     * @param response the object of <code>HttpServletRespone</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //List of top 5 recent news to display for RightPage
            //Get title by user input
            String title = request.getParameter("search");
            DigitalDAO digitalDAO = new DigitalDAOImpl();
            ArrayList<Digital> digitals = digitalDAO.getTop(6);
            Digital dig = digitals.remove(0);

            //set attribute for right.jsp
            request.setAttribute("dig", dig);
            request.setAttribute("title", title);
            request.setAttribute("digitals", digitals);

            //pagging
            String preIndex = request.getParameter("page");
            if (preIndex == null) {
                preIndex = "1";
            }
            int pageindex = Integer.parseInt(preIndex);
            int numRecords = digitalDAO.count(title.trim());
            int totalpage = (numRecords % 10 == 0)
                    ? numRecords / 3
                    : (numRecords / 3) + 1;
            ArrayList<Digital> digitalSearch = digitalDAO.search(title.trim(), pageindex, 3);

            //set attribute for search.jsp
            request.setAttribute("digitalSearch", digitalSearch);
            request.setAttribute("totalpage", totalpage);
            request.setAttribute("pageindex", pageindex);

            //Going to Seach.jsp
            request.getRequestDispatcher("Search.jsp").forward(request, response);
        } catch (Exception exception) {
            request.setAttribute("message", exception.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request the object of <code>HttpServletRequest</code>
     * @param response the object of <code>HttpServletRespone</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
