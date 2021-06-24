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
 * This class used DigitalDAO to get first digital news then forward to homePage.jsp
 *
 * @author Xuan Duc
 */
public class HomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request the object of <code>HttpServletRequest</code> 
     * @param response the object of <code>HttpServletRespone</code> 
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            //List of top 5 recent news to display for RightPage
            
            DigitalDAO digitalDAO = new DigitalDAOImpl();
            ArrayList<Digital> digitals = digitalDAO.getTop(6);
            Digital dig = digitals.remove(0);
            
            //set Attribute
            request.setAttribute("dig", dig);
            request.setAttribute("digitals", digitals);
            
            //Going  to homePage.jsp
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        } catch (Exception exception) {
            request.setAttribute("message", exception.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
