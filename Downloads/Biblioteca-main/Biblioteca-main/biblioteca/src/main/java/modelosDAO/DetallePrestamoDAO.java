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
import modelos.DetallePrestamo;
import modelos.Libro;

/**
 *
 * @author Alejandro
 */
public class DetallePrestamoDAO implements DML<DetallePrestamo>{

    private cn CN;
    private Connection con;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public DetallePrestamoDAO() {
        try {
            this.CN = new cn();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<DetallePrestamo> PrestamosActivos(int idPrestamo){
        ArrayList<DetallePrestamo> lista=new ArrayList<>();
        
        try{
            this.sql="SELECT lb.id_libro, dt.id_det_prestamo, lb.foto, lb.nombre, dt.cantidad, p.fecha_sistema, dt.estado FROM prestamo p JOIN det_prestamo dt ON p.id_prestamo = dt.id_prestamo JOIN libros lb ON lb.id_libro = dt.id_libro WHERE p.id_prestamo = ? AND p.estado = ? AND dt.estado = ?";
            ps=this.CN.getConnection().prepareStatement(this.sql);
            ps.setInt(1, idPrestamo);
            ps.setString(2, "1");
            ps.setString(3, "1");
            rs=ps.executeQuery();
            while (rs.next()){
                DetallePrestamo dtPrestamo = new DetallePrestamo();
                dtPrestamo.setIdLibro(rs.getInt("id_libro"));
                dtPrestamo.setIdDetPrestamo(rs.getInt("id_det_prestamo"));
                dtPrestamo.setFoto(rs.getString("foto"));
                dtPrestamo.setNombreLibro(rs.getString("nombre"));
                dtPrestamo.setCantidad(rs.getInt("cantidad"));
                dtPrestamo.setFecha_sistema(rs.getDate("fecha_sistema"));
                dtPrestamo.setEstado(rs.getString("estado"));
                lista.add(dtPrestamo);
            }
        }catch (Exception e){
        }
       
        return lista;
    }
    
    public int LibrosPrestados(int idDetalle){
        int CantidadPrestada = 0;
        try{
            this.sql="SELECT cantidad FROM det_prestamo WHERE id_det_prestamo = ?";
            ps=this.CN.getConnection().prepareStatement(this.sql);
            ps.setInt(1, idDetalle);
            rs=ps.executeQuery();
            while (rs.next()){
                CantidadPrestada = rs.getInt(1);
            }
        }catch (Exception e){
        }
       
        return CantidadPrestada;
    }
    
    public int idPrestamo(int idDetalle){
        int id = 0;
        try{
            this.sql="SELECT id_prestamo FROM det_prestamo WHERE id_det_prestamo = ?";
            ps=this.CN.getConnection().prepareStatement(this.sql);
            ps.setInt(1, idDetalle);
            rs=ps.executeQuery();
            while (rs.next()){
                id = rs.getInt(1);
            }
        }catch (Exception e){
        }
       
        return id;
    }
    
    public int informeDetalle(int idPrestamo){
        int CantidadLibros = 0;
        try{
            this.sql="SELECT COUNT(*) FROM det_prestamo WHERE id_prestamo = ? AND estado = '1'";
            ps=this.CN.getConnection().prepareStatement(this.sql);
            ps.setInt(1, idPrestamo);
            rs=ps.executeQuery();
            while (rs.next()){
                CantidadLibros = rs.getInt(1);
            }
        }catch (Exception e){
        }
       
        return CantidadLibros;
    }
    
    @Override
    public String insert(DetallePrestamo objeto) {
        String msj = "";
        this.sql="INSERT INTO det_prestamo (cantidad, estado, id_libro, id_prestamo) VALUES (?, ?, ?, ?);";
        
        try {
            ps=this.CN.getConnection().prepareStatement(this.sql);
            ps.setInt(1,objeto.getCantidad());
            ps.setString(2,objeto.getEstado());
            ps.setInt(3,objeto.getIdLibro());
            ps.setInt(4, objeto.getIdPrestamo());
            
            
            int filasAfectadas=ps.executeUpdate();
            
            if(filasAfectadas>0){
                msj = "Insertado exitosamente";
            }
        }catch (Exception e){
            return e.toString();
        }
        return msj;

    }

    @Override
    public String delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(DetallePrestamo objeto) {
        String msj = "";
        this.sql="UPDATE det_prestamo SET estado = '0' WHERE id_prestamo = ?";
        
        try {
            ps=this.CN.getConnection().prepareStatement(this.sql);
            ps.setInt(1,objeto.getId_det_prestamo());
            int filasAfectadas=ps.executeUpdate();
            
            if(filasAfectadas>0){
                msj = "Actualizado exitosamente";
            }
        }catch (Exception e){

        }
        return msj;
    }
    
     public String updateOne(DetallePrestamo objeto) {
        String msj = "";
        this.sql="UPDATE det_prestamo SET estado = '0' WHERE id_det_prestamo = ?";
        
        try {
            ps=this.CN.getConnection().prepareStatement(this.sql);
            ps.setInt(1,objeto.getId_det_prestamo());
            int filasAfectadas=ps.executeUpdate();
            
            if(filasAfectadas>0){
                msj = "Actualizado exitosamente";
            }
        }catch (Exception e){

        }
        return msj;
    }
}
