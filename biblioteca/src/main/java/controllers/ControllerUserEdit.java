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
import modelos.Encode;
import modelos.Usuario;
import modelosDAO.UsuarioDAO;

/**
 *
 * @author Alejandro
 */
@WebServlet(name = "ControllerUserEdit", urlPatterns = {"/ControllerUserEdit"})
public class ControllerUserEdit extends HttpServlet {

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
            out.println("<title>Servlet ControllerUserEdit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerUserEdit at " + request.getContextPath() + "</h1>");
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
        
        //clase de encriptar
        Encode encrip = new Encode();
        String claveEncriptada = "";
                
        //obtencion de datos
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombre");
        String apellidos = request.getParameter("apellido");
        String username = request.getParameter("username");
        int rol = Integer.parseInt(request.getParameter("rol"));
        String pass = request.getParameter("pass");
        
        try {
            claveEncriptada = encrip.encriptar(pass);
        } catch (Exception e) {
            
        }
        
        //listado
        ArrayList<Usuario> lUsuario = new ArrayList<>();
        //modelo
        Usuario usuario = new Usuario(id, nombres, apellidos, username, claveEncriptada, "a", rol);
        //DAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        //updatate del usuario
        usuarioDAO.update(usuario);
        lUsuario = usuarioDAO.listadoUsuarioEncrip();

        request.setAttribute("usuarios", lUsuario);
        
        RequestDispatcher dispatcher=request.getRequestDispatcher("/admin/usuario.jsp");
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
