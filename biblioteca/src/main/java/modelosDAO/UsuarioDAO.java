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
//                String clave = encrip.desencriptar(rs.getString(6));
//                usuario.setPasswordUser(clave);
                usuario.setPasswordUser(rs.getString(6));
                usuario.setRol(rs.getInt(7));
                
                lUsuario.add(usuario);
            }
        }catch (Exception e){
        }
        
        return lUsuario;
    }
    

    @Override
    public String insert(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
