/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Categoria;
import modelos.Libro;
import modelosDAO.LibroDAO;

/**
 *
 * @author martinsanabria
 */
@WebServlet(name = "LibroController", urlPatterns = {"/LibroController"})
public class LibroController extends HttpServlet {

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
            out.println("<title>Servlet LibroController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LibroController at " + request.getContextPath() + "</h1>");
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
           if(request.getParameter("action")!=null){
                if(request.getParameter("action").equals("edit")){
                int idproducto=Integer.parseInt(request.getParameter("id"));

                 //falta traer la persona de la base de datos
                 //y pasarlo como atributo
                RequestDispatcher dispatcher2=request.getRequestDispatcher("/LibrosView/edit.jsp");
                dispatcher2.forward(request,response);
                } else if (request.getParameter("action").equals("new")){
                    LibroDAO libros = new LibroDAO();
                    
                    List<Categoria> categorias = libros.ConsultaCategoria();

                    request.setAttribute("categorias", categorias);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/LibrosView/create.jsp");

            // Envía la solicitud al dispatcher.
            dispatcher.forward(request, response);
                }
           }
        } catch (Exception e) {
            e.printStackTrace(); //
        }
        
            LibroDAO libros = new LibroDAO();
            List<Libro> libroList = libros.ConsultaLibros();

            // Mapa para almacenar información adicional de libros
            Map<Integer, Map<String, String>> librosData = new HashMap<>();

           for (Libro libro : libroList) {
            // Obtener nombre de la categoría
            Categoria categoria = libros.consultarPorCategoria(libro.getIdCategoria());
            String nombreCategoria = (categoria != null) ? categoria.getNombre() : "";

            Map<String, String> libroData = new HashMap<>();
            libroData.put("nombreCategoria", nombreCategoria);

            librosData.put(libro.getId_libro(), libroData);

        }

            request.setAttribute("librosData", librosData);
            request.setAttribute("libros", libroList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/LibrosView/libros.jsp");
             // Envía la solicitud al dispatcher.
            dispatcher.forward(request, response);
            
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
