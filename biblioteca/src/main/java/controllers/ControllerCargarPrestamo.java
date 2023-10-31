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
import modelosDAO.LibroDAO;

/**
 *
 * @author Alejandro
 */
@WebServlet(name = "ControllerCargarPrestamo", urlPatterns = {"/ControllerCargarPrestamo"})
public class ControllerCargarPrestamo extends HttpServlet {

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
            out.println("<title>Servlet ControllerCargarPrestamo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerCargarPrestamo at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        
        //lista para cargar los libros
        ArrayList<Libro> Llibros = new ArrayList<>();
         //lista para la sesion
        ArrayList<Libro> Llibro = new ArrayList<>();
        LibroDAO libroDAO = new LibroDAO();
       
        //variable para saber si hay stock
        int cantidadStock, cantidadTotal;
        boolean bandEncontrar = false;
        
        int id_libro = Integer.parseInt(request.getParameter("id_libro"));
        String nombre = request.getParameter("titulo");
        String foto = request.getParameter("foto");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        
        Libro libro = new Libro(id_libro, nombre, cantidad, foto);
        
        //obtener el stock
        cantidadStock = libroDAO.cantidadLibro(id_libro);
        
        HttpSession session = request.getSession(true);
       
        if (session.getAttribute("ListaLibros") != null) {
           Llibro = (ArrayList<Libro>) session.getAttribute("ListaLibros");
            if (Llibro.size() > 0) {
                if (cantidad <= cantidadStock) {
                    for (int i = 0; i < Llibro.size(); i++) {
                        if (Llibro.get(i).getIdLibro() == id_libro) {
                            //si ha encontrado el libro
                            bandEncontrar = true;

                            cantidadTotal = Llibro.get(i).getCantidad() + cantidad;
                            if (cantidadTotal <= cantidadStock) {
                                Llibro.get(i).setCantidad(cantidadTotal);
                                session.setAttribute("ListaLibros", Llibro);
                                request.setAttribute("conteoLibros", Llibro.size());
                            }
                            else{
                                request.setAttribute("id", id_libro);
                                request.setAttribute("msj", "No hay suficiente stock");
                            }
                           break;
                        }
                    }
                    if (!bandEncontrar) {
                        Llibro.add(libro);
                        session.setAttribute("ListaLibros", Llibro);
                        request.setAttribute("conteoLibros", Llibro.size());
                    }
                }
                else{
                    request.setAttribute("conteoLibros", Llibro.size());
                    request.setAttribute("msj", "No hay suficiente stock");
                }
            }
            else{
                Llibro.add(libro);
                session.setAttribute("ListaLibros", Llibro);
                request.setAttribute("conteoLibros", Llibro.size());
            }
            
        }
        else{
            if (cantidad <= cantidadStock) {
                Llibro.add(libro);
                session.setAttribute("ListaLibros", Llibro);
                request.setAttribute("conteoLibros", Llibro.size());
            }
            else{
                request.setAttribute("id", id_libro);
                request.setAttribute("msj", "No hay suficiente stock");
            }
        }
       
        
        Llibros = libroDAO.LibrosActivos();
        
        request.setAttribute("libros", Llibros);
        
        RequestDispatcher dispatcher=request.getRequestDispatcher("libros.jsp");
        dispatcher.forward(request,response); 
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
