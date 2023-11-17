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
@WebServlet(name = "ControllerUser", urlPatterns = {"/ControllerUser"})
public class ControllerUser extends HttpServlet {

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
            out.println("<title>Servlet ControllerUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerUser at " + request.getContextPath() + "</h1>");
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
        
        Encode encrip = new Encode();
        //listado
        ArrayList<Usuario> lUsuario = new ArrayList<>();
        //modelo
        Usuario usuario = new Usuario();
        
        //DAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();
       
        //obtener los datos de la base de datos
        lUsuario = usuarioDAO.listadoUsuarioEncrip();
        
        //condional de edit y delete
        if (request.getParameter("action")!= null) {
            int id = Integer.parseInt( request.getParameter("id"));
            if (request.getParameter("action").equals("edit")) {
                for (Usuario user : lUsuario) {
                    if (user.getIdUsuario() == id) {
                        String clave = "";
                        try {
                            clave = encrip.desencriptar(user.getPasswordUser());
                        } catch (Exception e) {
                        }
                        usuario = new Usuario(user.getIdUsuario(), user.getNombres(), user.getApellidos(), user.getUsername(),
                                clave, user.getEstado(), user.getRol());
                        
                        request.setAttribute("usuario", usuario);
                        
                        RequestDispatcher dispatcher=request.getRequestDispatcher("/admin/usuarioEdit.jsp");
                        dispatcher.forward(request,response); 
                    }
                    
                }
            }
            else if(request.getParameter("action").equals("del")){
                try {
                    usuarioDAO.delete(id);
                    lUsuario = usuarioDAO.listadoUsuarioEncrip();
                } catch (Exception e) {
                    request.setAttribute("msj", "Error al desactivar");
                }
                
            }
            else if(request.getParameter("action").equals("act")){
                try {
                    usuarioDAO.activar(id);
                    lUsuario = usuarioDAO.listadoUsuarioEncrip();
                } catch (Exception e) {
                    request.setAttribute("msj", "Error al activar");
                }
                
            }
        }
        
        request.setAttribute("usuarios", lUsuario);
        
        RequestDispatcher dispatcher=request.getRequestDispatcher("/admin/usuario.jsp");
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
        
        //clase de encriptar
        Encode encrip = new Encode();
        String claveEncriptada = "";
                
        //obtencion de datos
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
        Usuario usuario = new Usuario(nombres, apellidos, username, claveEncriptada, "a", rol);
        //DAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        lUsuario = usuarioDAO.listadoUsuarioEncrip();
        
        for (Usuario usuarior : lUsuario) {
            if (!usuarior.getNombres().toLowerCase().equals(usuario.getNombres().toLowerCase()) && 
                    !usuarior.getApellidos().toLowerCase().equals(usuario.getApellidos().toLowerCase()) &&
                    !usuarior.getUsername().equals(usuario.getUsername())) {
                //insert del usuario
                usuarioDAO.insert(usuario);
                lUsuario = usuarioDAO.listadoUsuarioEncrip();
            }
            else{
                request.setAttribute("msj", "El usuario ya existe");
            }
        }       
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
