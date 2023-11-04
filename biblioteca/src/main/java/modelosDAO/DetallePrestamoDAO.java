/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDAO;

import db.cn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.DetallePrestamo;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
