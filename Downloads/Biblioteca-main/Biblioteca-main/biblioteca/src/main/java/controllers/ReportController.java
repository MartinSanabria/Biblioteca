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
import modelos.Categoria;
import modelos.Libro;
import modelosDAO.CategoriaDAO;
import modelosDAO.LibroDAO;

/**
 *
 * @author martinsanabria
 */
@WebServlet(name = "ReportController", urlPatterns = {"/ReportController"})
public class ReportController extends HttpServlet {

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
            out.println("<title>Servlet ReportController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReportController at " + request.getContextPath() + "</h1>");
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
                CategoriaDAO categoriad = new CategoriaDAO();
                List<Categoria> categoriaList = categoriad.ObtenerCategorias();

                LibroDAO libros = new LibroDAO();
                List<Libro> libroList;

                // Obtener el parámetro de categoría seleccionada
                String categoriaSeleccionadaId = request.getParameter("categoriaId");

                if (categoriaSeleccionadaId == null || categoriaSeleccionadaId.isEmpty() || categoriaSeleccionadaId.equals("0")) {
                    // Si no se selecciona ninguna categoría o se selecciona "Todas las categorías"
                    libroList = libros.ConsultaLibros();
                    categoriaSeleccionadaId = "0";  // Definimos "0" como el ID para "Todas las categorías"
                } else {
                    // Si se selecciona una categoría específica
                    int idCategoriaSeleccionada = Integer.parseInt(categoriaSeleccionadaId);
                    libroList = libros.consultarLibrosPorCategoria(idCategoriaSeleccionada);
        }

                // Mapa para almacenar información adicional de libros
                Map<Integer, Map<String, String>> librosData = new HashMap<>();

                for (Libro libro : libroList) {
                    // Obtener nombre de la categoría
                    Categoria categoria = libros.consultarPorCategoria(libro.getId_categoria());
                    String nombreCategoria = (categoria != null) ? categoria.getNombre() : "";

                    Map<String, String> libroData = new HashMap<>();
                    libroData.put("nombreCategoria", nombreCategoria);

                    librosData.put(libro.getId_libro(), libroData);
                }

                request.setAttribute("librosData", librosData);
                request.setAttribute("libros", libroList);
                request.setAttribute("categorias", categoriaList);
                request.setAttribute("selectedCategoryId", categoriaSeleccionadaId);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminReports/reports.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }

        
        
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
