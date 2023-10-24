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
    
     public List ConsultaCategoria(){

        ArrayList<Categoria> lista=new ArrayList<>();
        this.sql="select * from categoria";
        try {
            ps=this.CN.getConnection().prepareStatement(this.sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Categoria categoria=new Categoria();
<<<<<<< HEAD
                categoria.setId_categoria(rs.getInt("id_categoria"));
                categoria.setNombre(rs.getString("nombre_categoria"));
=======
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNombre(rs.getString("nombre"));
>>>>>>> f08d936 (Creacion de metodos libros)
                categoria.setEstado(rs.getString("estado"));
                categoria.setEdicion(rs.getString("edicion"));
                lista.add(categoria);
            }
        }catch (Exception e){

        }
        return lista;
    }
    
    public Libro buscarPorID(int id){
        this.sql="select * from libros where id_libro=?";
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
    
   public Categoria consultarPorCategoria(int idcategoria){

        this.sql = "select * from categoria where id_categoria=?";
        Categoria categoria = new Categoria();

        try {
            ps = this.CN.getConnection().prepareStatement(this.sql);
            ps.setInt(1, idcategoria);
            rs = ps.executeQuery();

            while (rs.next()){
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                categoria.setIdCategoria(rs.getInt("idcategoria"));
                categoria.setNombre(rs.getString("nombre_categoria"));
                categoria.setEstado(rs.getString("estado"));
                categoria.setEdicion(rs.getString("edicion"));
=======
                categoria.setId_categoria(rs.getInt("idcategoria"));
                categoria.setNombre(rs.getString("nombre_categoria"));
>>>>>>> 4415093 (Adding create category and deactivate category)
=======
=======
>>>>>>> 4a537dd (Correciones)
                categoria.setId_categoria(rs.getInt("idcategoria"));
                categoria.setNombre(rs.getString("nombre_categoria"));
                categoria.setNombre(rs.getString("nombre_categoria"));
                categoria.setEstado(rs.getString("estado"));
                categoria.setEdicion(rs.getString("edicion"));
<<<<<<< HEAD
>>>>>>> 2ccd390 (Modificacion vistas libro)
>>>>>>> 733ec75 (Rebase merge)
=======

>>>>>>> 4a537dd (Correciones)
=======
                categoria.setId_categoria((rs.getInt("idcategoria")));
                categoria.setNombre(rs.getString("nombre_categoria"));
                categoria.setEstado(rs.getString("estado"));
                categoria.setEdicion(rs.getString("edicion"));
>>>>>>> a24b303 (Conflictos)
=======
                categoria.setId_categoria(rs.getInt("idcategoria"));
                categoria.setNombre(rs.getString("nombre_categoria"));
=======
                categoria.setIdCategoria(rs.getInt("idcategoria"));
                categoria.setNombre(rs.getString("nombre_categoria"));
                categoria.setEstado(rs.getString("estado"));
                categoria.setEdicion(rs.getString("edicion"));
>>>>>>> bb5e55e (merge categorias)
>>>>>>> b4d848d (Cambios remotos)
            
=======
                categoria.setIdCategoria(rs.getInt("id_categoria"));  // Asegúrate de que los nombres coincidan
                categoria.setNombre(rs.getString("nombre"));
                categoria.setEstado(rs.getString("estado"));
                categoria.setEdicion(rs.getString("edicion"));
>>>>>>> f08d936 (Creacion de metodos libros)
            }

        } catch (Exception e) {
            e.printStackTrace();  // Agrega esta línea para imprimir la traza de la excepción
        }

        return categoria;
    }

       
     public boolean agregar(Libro libro){
        this.sql="insert into libros(nombre, autor, cantidad, foto, estado, id_categoria) values(?,?,?,?,?,?)";
        
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

    public boolean actualizar(Libro libro){
        this.sql="update clientes set nombre=?,autor=?,cantidad=?,foto=?,estado=?,id_categoria=? where id_libro=?";
        try {
           ps=this.CN.getConnection().prepareStatement(this.sql);
            ps.setString(1,libro.getNombre());
            ps.setString(2,libro.getAutor());
            ps.setInt(3,libro.getCantidad());
            ps.setString(4,libro.getFoto());
            ps.setString(5,libro.getEstado());
             ps.setInt(6,libro.getIdCategoria());
            ps.setInt(7,libro.getIdLibro());
            int filasAfectadas=ps.executeUpdate();
            if(filasAfectadas>0){
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }
    
     public boolean eliminar(int id){
        this.sql="delete from libros where id_libro=?";
        try {
            ps=this.CN.getConnection().prepareStatement(this.sql);
            ps.setInt(1,id);
            int filasAfectadas=ps.executeUpdate();
            if(filasAfectadas>0){
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }
    
}
