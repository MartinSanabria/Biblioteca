/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelosDAO.CategoriaDAO;
import modelos.Categoria;
import modelos.Libro;
import modelosDAO.LibroDAO;

/**
 *
 * @author PC
 */
@WebServlet(name = "CategoriaController", urlPatterns = {"/CategoriaController"})
public class CategoriaController extends HttpServlet {

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
            out.println("<title>Servlet CategoriaController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CategoriaController at " + request.getContextPath() + "</h1>");
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

        try {
            if (request.getParameter("action") != null) {
                if (request.getParameter("action").equals("edit")) {
                    int idCategoria = Integer.parseInt(request.getParameter("id"));
                    CategoriaDAO categorias = new CategoriaDAO();
                    Categoria catfound = categorias.buscarPorId(idCategoria);
                    request.setAttribute("catEdit", catfound);

                    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/admin/editCategorias.jsp");
                    dispatcher2.forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); //
        }

        CategoriaDAO categoria = new CategoriaDAO();

        List<Categoria> categoriaList = categoria.ObtenerCategorias();
        request.setAttribute("categorias", categoriaList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/verCategorias.jsp");
        dispatcher.forward(request, response);
        // Envía la solicitud al dispatcher.

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

        CategoriaDAO categoria = new CategoriaDAO();
        try{
        if (request.getParameter("action").equals("deactivate")) {
            categoria.eliminar(Integer.parseInt(request.getParameter("id")));
        } else if (request.getParameter("action").equals("activate")) {
            categoria.activar(Integer.parseInt(request.getParameter("id")));
        } else if (request.getParameter("action").equals("update")) {     
            categoria.actualizar(request.getParameter("name"), request.getParameter("edicion"), Integer.parseInt(request.getParameter("inputId")));
            String successMessage = "Categoria actualizado satisfactoriamente";
            request.setAttribute("successMessage", successMessage);
        } else if (request.getParameter("action").equals("create")) {
            Categoria prov = new Categoria(request.getParameter("name"), request.getParameter("estado"), request.getParameter("edicion"));
            categoria.insert(prov);
            String successMessage = "Categoria agregada satisfactoriamente";
            request.setAttribute("successMessage", successMessage);
        }
        } catch(Exception e){
            String errorMessage = "Error";
            request.setAttribute("errorMessage", errorMessage);
        }

        doGet(request, response);
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
