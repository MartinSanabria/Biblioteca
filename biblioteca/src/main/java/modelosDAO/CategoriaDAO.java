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
import java.util.List;
import modelos.Categoria;

/**
 *
 * @author Alejandro
 */
public class CategoriaDAO implements DML<Categoria>{

    private cn CN;
    private Connection con;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CategoriaDAO() {
        try {
            this.CN = new cn();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Categoria> ObtenerCategorias(){
        List<Categoria> lista=new ArrayList<>();
        
        try{
            this.sql="SELECT * FROM categoria";
            ps=this.CN.getConnection().prepareStatement(this.sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Categoria categoria=new Categoria();
   
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNombre(rs.getString("nombre"));
                categoria.setEstado(rs.getString("estado"));
                categoria.setEdicion(rs.getString("edicion"));
                lista.add(categoria);
            }
        }catch (Exception e){
        }
       
        return lista;
    }
    
    @Override
    public String insert(Categoria objeto) {
        String msj = "";
        String sql="INSERT INTO categoria (nombre, estado, edicion) VALUES (?, ?, ?);";
        try {
            con=CN.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, objeto.getNombre());
            ps.setString(2, objeto.getEstado());
            ps.setString(3, objeto.getEdicion());
            
            
            int filasAfectadas=ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                msj = "Ingresado";
            }
        }catch (Exception e){
            msj = "Error"+e.toString();
        }
        return msj;
    }

    @Override
    public String delete(int id) {
        String msj = "";
        String sql = "DELETE FROM categoria WHERE id_categoria = ?";
        try {
            con=CN.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            int filasAfectadas=ps.executeUpdate();
            if (filasAfectadas > 0) {
                msj = "Eliminado";
            }
        }catch (Exception e){
            msj = "Error"+e.toString();
        }
        return msj;
    }

    @Override
    public String update(Categoria objeto) {
        String msj = "";
        String sql="UPDATE categoria SET nombre = ?, estado = ?, edicion = ? WHERE id_categoria = ?;";
        try {
            con=CN.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,objeto.getNombre());
            ps.setString(2, objeto.getEstado());
            ps.setString(3, objeto.getEdicion());
            ps.setInt(2, objeto.getIdCategoria());
            
            int filasAfectadas=ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                msj = "Actualizado";
            }
        }catch (Exception e){
            msj = "Error"+e.toString();
        }
        return msj;
    }
    
}
