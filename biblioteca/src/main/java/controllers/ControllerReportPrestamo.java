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
        
        DetallePrestamo detallePrestamo = new DetallePrestamo();
        
        LibroDAO libroDAO = new LibroDAO();
        DetallePrestamoDAO detallePrestamoDAO = new DetallePrestamoDAO();
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        
        
        ArrayList<Prestamo> Lprestamos=new ArrayList<>();
        //lista para actuaizar el stock
        ArrayList<DetallePrestamo> lDetPrestamo = new ArrayList<>();
        
        if (session.getAttribute("usuario") == null) {
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
        
        if (request.getParameter("action") != null) {
            int  id = Integer.parseInt(request.getParameter("id"));
            prestamo = new Prestamo( id);
            detallePrestamo = new DetallePrestamo( id);
            
            if (request.getParameter("action").equals("backOne")) {
                int total = 0;
                
                //obtener el id del libro
                int idLibro =  Integer.parseInt(request.getParameter("idLibro"));
                //obtener el stock y lo que se ha prestado para sumarlo
                int stock = libroDAO.cantidadLibro(idLibro);
                int CantPrestada = detallePrestamoDAO.LibrosPrestados(id);
                
                
                total= stock + CantPrestada;
                Libro libro = new Libro(idLibro, total);
                
                //se actualiza el stock y el estado
                libroDAO.actualizarStock(libro);
                detallePrestamoDAO.updateOne(detallePrestamo);
               
                //se evalua si tiene libros aun sino se actualiza
                int idPrestamo = detallePrestamoDAO.idPrestamo(id);
                int CantidadLibros = detallePrestamoDAO.informeDetalle(idPrestamo);
                if (CantidadLibros == 0) {
                    prestamo = new Prestamo(idPrestamo);
                    prestamoDAO.update( prestamo);
                }
               
                
            }
            else if(request.getParameter("action").equals("backAll")){
                lDetPrestamo = detallePrestamoDAO.PrestamosActivos(id);
                for (DetallePrestamo item : lDetPrestamo) {
                    int stock = libroDAO.cantidadLibro(item.getIdLibro());
                    int CantPrestada = detallePrestamoDAO.LibrosPrestados(item.getIdDetPrestamo());
                    int total = stock + CantPrestada;
                    Libro libro = new Libro(item.getIdLibro(), total);
                    libroDAO.actualizarStock(libro);
                }
                prestamoDAO.update(prestamo);
                detallePrestamoDAO.update(detallePrestamo);
            }
        }
        
        Lprestamos = prestamoDAO.prestamosActivos((int) session.getAttribute("id"));
        request.setAttribute("prestamos", Lprestamos);
        
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
        
        HttpSession session = request.getSession(false);
         
        int idPrestamo = Integer.parseInt(request.getParameter("idPrestamo"));
        DetallePrestamoDAO detPrestamoDAO = new DetallePrestamoDAO();
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        
        //lista de libros prestados
        ArrayList<DetallePrestamo> lDetPrestamo = new ArrayList<>();
        //listado de fechas
        ArrayList<Prestamo> Lprestamos=new ArrayList<>();
        
        
        if (idPrestamo > 0) {
            //se obtienen los libros prestados
            lDetPrestamo = detPrestamoDAO.PrestamosActivos(idPrestamo);
            request.setAttribute("LdetPrestamo", lDetPrestamo);
            request.setAttribute("id", idPrestamo);
        }
        
        Lprestamos = prestamoDAO.prestamosActivos((int) session.getAttribute("id"));
        request.setAttribute("prestamos", Lprestamos);
        
        
        RequestDispatcher dispatcher=request.getRequestDispatcher("prestamos.jsp");
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
