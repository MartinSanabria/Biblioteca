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
import modelos.DetallePrestamo;
import modelos.Libro;
import modelos.Prestamo;
import modelosDAO.DetallePrestamoDAO;
import modelosDAO.LibroDAO;
import modelosDAO.PrestamoDAO;

/**
 *
 * @author Alejandro
 */
@WebServlet(name = "ControllerSavePrestamo", urlPatterns = {"/ControllerSavePrestamo"})
public class ControllerSavePrestamo extends HttpServlet {

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
            out.println("<title>Servlet ControllerSavePrestamo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerSavePrestamo at " + request.getContextPath() + "</h1>");
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
        ArrayList<Libro> Llibros = new ArrayList<>();
        ArrayList<Libro> Llibrosbiblioteca = new ArrayList<>();
        int idPrestamo;
        
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        DetallePrestamoDAO detallePrestamoDAO = new DetallePrestamoDAO();
        DetallePrestamo detallePrestamo = null;
        Prestamo prestamo = new Prestamo();
        
        
        LibroDAO libroDAO = new LibroDAO();
        Libro libro = new Libro();
        
        
        //se evalua la accion que hara 
        if (request.getParameter("action") != null) {
            if (request.getParameter("action").equals("prestar")) {
                //se evalua si esta logeado
                if (session.getAttribute("usuario") != null) {
                    int idUsuario = (Integer) session.getAttribute("id");
                    
                    if (session.getAttribute("ListaLibros") != null) {
                        Llibros = (ArrayList<Libro>) session.getAttribute("ListaLibros");
                        if (Llibros.size() > 0) {
                            
                            //insert
                            prestamo = new Prestamo(idUsuario, "1");
                            prestamoDAO.insert(prestamo);
                            //cargar el id de prestamo
                            idPrestamo = prestamoDAO.ultimoIngresado();
                           //insert el detalle de prestamo
                            for (Libro book : Llibros) {
                                detallePrestamo = new DetallePrestamo( book.getCantidad(), book.getIdLibro(), idPrestamo, "1");
                                detallePrestamoDAO.insert(detallePrestamo);
                                int cantidadStock = libroDAO.cantidadLibro(book.getIdLibro());
                                cantidadStock = cantidadStock - book.getCantidad();
                                
                                libro = new Libro(book.getIdLibro(), cantidadStock);
                                libroDAO.actualizarStock(libro);
                            }
                            session.setAttribute("ListaLibros", null);
                            request.setAttribute("libros",null);
                            RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
                            dispatcher.forward(request,response); 
                        }
                        else{
                            Llibrosbiblioteca = libroDAO.LibrosActivos();
                            
                            request.setAttribute("libros",Llibrosbiblioteca);
                            RequestDispatcher dispatcher=request.getRequestDispatcher("libros.jsp");
                            dispatcher.forward(request,response); 
                        }
                    }
                    else{
                        Llibrosbiblioteca = libroDAO.LibrosActivos();
                            
                        request.setAttribute("libros",Llibrosbiblioteca);
                        RequestDispatcher dispatcher=request.getRequestDispatcher("libros.jsp");
                        dispatcher.forward(request,response); 
                    }
                }
                else{
                    RequestDispatcher dispatcher=request.getRequestDispatcher("login/login.jsp");
                    dispatcher.forward(request,response); 
                }
            }
            else if(request.getParameter("action").equals("cancel")){
                if (session.getAttribute("ListaLibros") != null) {
                    
                    session.setAttribute("ListaLibros", null);
                    request.setAttribute("libros", null);
                    request.setAttribute("msj", "Prestamo cancelado");
                    RequestDispatcher dispatcher=request.getRequestDispatcher("prestamo.jsp");
                    dispatcher.forward(request,response); 
                }
            }
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
