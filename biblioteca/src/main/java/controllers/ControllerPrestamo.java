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
@WebServlet(name = "ControllerPrestamo", urlPatterns = {"/ControllerPrestamo"})
public class ControllerPrestamo extends HttpServlet {

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
            out.println("<title>Servlet ControllerPrestamo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerPrestamo at " + request.getContextPath() + "</h1>");
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
        
        //variables
        ArrayList<Libro> Llibro = new ArrayList<>();
        Libro libro = null;
        LibroDAO libroDAO = new LibroDAO();
        
        //aqui se carga la tabla si existen datos en la sesion 
        HttpSession session = request.getSession(false);
        if (session.getAttribute("ListaLibros") != null) {
            Llibro = (ArrayList<Libro>) session.getAttribute("ListaLibros");
            if(Llibro.size() > 0){
                request.setAttribute("conteoLibros", Llibro.size());
                request.setAttribute("libros", Llibro);
            }
            else{
                request.setAttribute("msj", "Aun no se han agregado prestamos");
            }
        }
        else{
            request.setAttribute("msj", "Aun no se han agregado prestamos");
        }
        
        //condicionalles para saber si la accion es update o delete
        if (request.getParameter("action")!= null) {
            //obtener el id
            int id_libro = Integer.parseInt( request.getParameter("id_libro"));
            if (request.getParameter("action").equals("edit")) {
                //se evalua si hay datos en la lista
                if (Llibro.size() > 0) {
                    //se recorre la lista en busca del libro a editar
                    for (Libro libro1 : Llibro) {
                        //evvaluacion 
                        if (libro1.getIdLibro() == id_libro) {
                            //se carga el libro si se encuentra
                            libro = new Libro(libro1.getIdLibro(), libro1.getNombre(), libro1.getCantidad(),libro1.getFoto());  
                            //se manda a la vista
                            request.setAttribute("libro", libro);
                            //llamado de la vista con el dato del libro
                            RequestDispatcher dispatcher=request.getRequestDispatcher("editPrestamo.jsp");
                            dispatcher.forward(request,response); 
                        }
                    }
                }
                
            }
            //si la action es delete. Eliminara el libro de la sesion
            else if(request.getParameter("action").equals("del")){
                if (Llibro.size() > 0) {
                    //se recorre la lista en busca del libro a eliminar
                    for (int i = 0; i < Llibro.size(); i++) {
                        if (Llibro.get(i).getIdLibro() == id_libro) {
                            Llibro.remove(i);
                            request.setAttribute("conteoLibros", Llibro.size());
                            request.setAttribute("libros", Llibro);
                        }
                    }
                }
            }
        }
        
        RequestDispatcher dispatcher=request.getRequestDispatcher("prestamo.jsp");
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
       
        ArrayList<Libro> Llibro = new ArrayList<>();
        Libro libro = null;
        LibroDAO libroDAO = new LibroDAO();
        
        int id_libro = Integer.parseInt(request.getParameter("id_libro"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        
        int cantidadStock = libroDAO.cantidadLibro(id_libro);
        
        HttpSession session = request.getSession(true);
        
        if (cantidad <= cantidadStock) {
            if(session.getAttribute("ListaLibros")!= null){
                Llibro = (ArrayList<Libro>) session.getAttribute("ListaLibros");
                if (Llibro.size() > 0) {
                    for (int i = 0; i < Llibro.size(); i++) {
                        if (Llibro.get(i).getIdLibro() == id_libro) {
                            Llibro.get(i).setCantidad(cantidad);
                        }
                    }
                }
                request.setAttribute("libros", Llibro);
                request.setAttribute("conteoLibros", Llibro.size());
                
                RequestDispatcher dispatcher=request.getRequestDispatcher("prestamo.jsp");
                dispatcher.forward(request,response);
            }
        }else{
            if(session.getAttribute("ListaLibros")!= null){
                Llibro = (ArrayList<Libro>) session.getAttribute("ListaLibros");
                for (int i = 0; i < Llibro.size(); i++) {
                    if (Llibro.get(i).getIdLibro() == id_libro) {
                        libro = new Libro(Llibro.get(i).getIdLibro(), Llibro.get(i).getNombre(), Llibro.get(i).getCantidad(), Llibro.get(i).getFoto());
                    }
                }
                request.setAttribute("libro", libro);
                request.setAttribute("conteoLibros", Llibro.size());
                request.setAttribute("msj", "No hay suficiente stock");

                RequestDispatcher dispatcher=request.getRequestDispatcher("editPrestamo.jsp");
                dispatcher.forward(request,response); 
            }
        }
        
         
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
