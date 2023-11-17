/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDAO;

import db.cn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelos.Encode;
import modelos.Usuario;
/**
 *
 * @author Alejandro
 */
public class UsuarioDAO implements DML<Usuario>{
    
    private cn CN;
    private Connection con;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public UsuarioDAO() {
        try {
            this.CN = new cn();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<Usuario> listadoUsuario(){
        Encode encrip = new Encode();
        ArrayList<Usuario> lUsuario = new ArrayList<>();
        try{
            this.sql="SELECT * FROM usuario";
            ps=this.CN.getConnection().prepareStatement(this.sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombres(rs.getString(2));
                usuario.setApellidos(rs.getString(3));
                usuario.setUsername(rs.getString(4));
                usuario.setEstado(rs.getString(5));
                String clave = encrip.desencriptar(rs.getString(6));
                usuario.setPasswordUser(clave);
                usuario.setRol(rs.getInt(7));
                
                lUsuario.add(usuario);
            }
        }catch (Exception e){
        }
        
        return lUsuario;
    }
    
    public ArrayList<Usuario> listadoUsuarioEncrip(){
        Encode encrip = new Encode();
        ArrayList<Usuario> lUsuario = new ArrayList<>();
        try{
            this.sql="SELECT * from usuario us JOIN roles r on us.id_rol = r.id_rol";
            ps=this.CN.getConnection().prepareStatement(this.sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombres(rs.getString(2));
                usuario.setApellidos(rs.getString(3));
                usuario.setUsername(rs.getString(4));
                usuario.setEstado(rs.getString(5));
                usuario.setPasswordUser(rs.getString(6));
                usuario.setRol(rs.getInt(7));
                usuario.setRolName(rs.getString(9));             
                lUsuario.add(usuario);
            }
        }catch (Exception e){
        }
        
        return lUsuario;
    }
    

    @Override
    public String insert(Usuario objeto) {
        String msj = "";
        String sql = "INSERT INTO usuario (nombres, apellidos, username, estado, password_user, id_rol) VALUES (?, ?, ?, ?, ?, ?)";
        try { 
            con=CN.getConnection();
            ps=con.prepareStatement(sql);

            // Establece los valores para los signos de interrogación
            ps.setString(1, objeto.getNombres());  // Reemplaza "valor-2" con el valor real
            ps.setString(2, objeto.getApellidos());  // Reemplaza "valor-3" con el valor real
            ps.setString(3, objeto.getUsername());  // Reemplaza "valor-4" con el valor real
            ps.setString(4, objeto.getEstado());  // Reemplaza "valor-5" con el valor real
            ps.setString(5, objeto.getPasswordUser());  // Reemplaza "valor-6" con el valor real
            ps.setInt(6, objeto.getRol());  // Reemplaza valor-7 con el valor real

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                msj = "insertado";
            }
        } catch (Exception e) {
            msj = "Error "+e.toString();
        }
        return msj;
    }

    @Override
    public String delete(int id) {
        String msj = "";
        String sql = "UPDATE usuario SET estado = 'd' WHERE id_usuario = ?";
        try {
            con=CN.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1 , id);
            
            int filasAfectadas=ps.executeUpdate();
            
            if(filasAfectadas>0){
                msj = "Se desactivo exitosamente";
            }
        }catch (Exception e){
            msj = "Error al desactivar";
        }
        return msj;
    }

    @Override
    public String update(Usuario objeto) {
        String msj = "";
        String sql="UPDATE usuario SET nombres=?, apellidos=?, username=?, password_user=?, id_rol=? WHERE id_usuario = ?";
        try {
            con=CN.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,objeto.getNombres());
            ps.setString(2, objeto.getApellidos());
            ps.setString(3, objeto.getUsername());
            ps.setString(4, objeto.getPasswordUser());
            ps.setInt(5, objeto.getRol());
            ps.setInt(6, objeto.getIdUsuario());
            
            int filasAfectadas=ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                msj = "Actualizado";
            }
        }catch (Exception e){
            msj = "Error"+e.toString();
        }
        return msj;
    }
    
    public String activar(int id) {
        String msj = "";
        String sql = "UPDATE usuario SET estado = 'a' WHERE id_usuario = ?";
        try {
            con=CN.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1 , id);
            
            int filasAfectadas=ps.executeUpdate();
            
            if(filasAfectadas>0){
                msj = "Se activo exitosamente";
            }
        }catch (Exception e){
            msj = "Error al activar";
        }
        return msj;
    }
}
