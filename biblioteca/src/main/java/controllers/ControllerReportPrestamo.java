/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Libro;
import modelos.Prestamo;
import modelosDAO.PrestamoDAO;

/**
 *
 * @author Alejandro
 */
@WebServlet(name = "ControllerReportPrestamo", urlPatterns = {"/ControllerReportPrestamo"})
public class ControllerReportPrestamo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerReportPrestamo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerReportPrestamo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession session = request.getSession(false);
        ArrayList<Libro> Llibro = new ArrayList();
        
        Prestamo prestamo = new Prestamo();
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        ArrayList<Prestamo> Lprestamos=new ArrayList<>();
        
        if (session.getAttribute("usuario") == null) {
            Lprestamos = prestamoDAO.prestamosActivos((int) session.getAttribute("id"));
            request.setAttribute("prestamos", Lprestamos);
            
            RequestDispatcher dispatcher=request.getRequestDispatcher("login/login.jsp");
            dispatcher.forward(request,response);
        }
        if (session.getAttribute("ListaLibros") != null) {
            Llibro = (ArrayList<Libro>) session.getAttribute("ListaLibros");
            if (Llibro.size() > 0) {
                request.setAttribute("conteoLibros", Llibro.size());
            }
            else{
                RequestDispatcher dispatcher=request.getRequestDispatcher("libros.jsp");
                dispatcher.forward(request,response);
            }
        }
        

        
        RequestDispatcher dispatcher=request.getRequestDispatcher("prestamos.jsp");
        dispatcher.forward(request,response); 
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
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
