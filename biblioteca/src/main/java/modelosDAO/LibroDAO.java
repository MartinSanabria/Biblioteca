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
import modelos.Libro;
/**
 *
 * @author Alejandro
 */
public class LibroDAO {
    
    private cn CN;
    private Connection con;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public LibroDAO() {
        try {
            this.CN = new cn();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Libro> ConsultaLibros(){
        List<Libro> lista=new ArrayList<>();
        
        try{
            this.sql="SELECT * FROM libros";
            ps=this.CN.getConnection().prepareStatement(this.sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Libro libro=new Libro();
   
                libro.setIdLibro(rs.getInt("id_libro"));
                libro.setNombre(rs.getString("nombre"));
                libro.setAutor(rs.getString("autor"));
                libro.setCantidad(rs.getInt("cantidad"));
                libro.setFoto(rs.getString("foto"));
                libro.setEstado(rs.getString("estado"));
                libro.setIdCategoria(rs.getInt("id_categoria"));
                lista.add(libro);
            }
        }catch (Exception e){
        }
       
        return lista;
    }
    
    public Libro buscarPorID(int id){
        String sql="select * from libros where id_libro=?";
        Libro libro=new Libro();
        try {
            ps=this.CN.getConnection().prepareStatement(this.sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while (rs.next()){
                libro.setIdLibro(rs.getInt("id_libro"));
                libro.setNombre(rs.getString("nombre"));
                libro.setAutor(rs.getString("autor"));
                libro.setCantidad(rs.getInt("cantidad"));
                libro.setFoto(rs.getString("foto"));
                libro.setEstado(rs.getString("estado"));
                libro.setIdCategoria(rs.getInt("id_categoria"));
            
            }

        }catch (Exception e){

        }
        return libro;
    }

     public boolean agregar(Libro libro){
        String sql="insert into libros(nombre, autor, cantidad, foto, estado, id_categoria) values(?,?,?,?,?,?)";
        
        try {
            ps=this.CN.getConnection().prepareStatement(this.sql);
            ps.setString(1,libro.getNombre());
            ps.setString(2,libro.getAutor());
            ps.setInt(3,libro.getCantidad());
            ps.setString(4,libro.getFoto());
            ps.setString(5,libro.getEstado());
            ps.setInt(6,libro.getIdCategoria());
            int filasAfectadas=ps.executeUpdate();
            if(filasAfectadas>0){
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }


    
}
