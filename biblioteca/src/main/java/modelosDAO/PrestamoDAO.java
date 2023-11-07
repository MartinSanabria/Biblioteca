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
import modelos.Prestamo;

/**
 *
 * @author Alejandro
 */
public class PrestamoDAO implements DML<Prestamo>{
    private cn CN;
    private Connection con;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public PrestamoDAO() {
        try {
            this.CN = new cn();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int ultimoIngresado(){
        int idPrestamo = 0;
        this.sql = "SELECT id_prestamo FROM prestamo ORDER BY id_prestamo DESC LIMIT 1";
        try {
            ps=this.CN.getConnection().prepareStatement(this.sql);
            rs=ps.executeQuery();
            while (rs.next()){
                idPrestamo = rs.getInt(1);
            }
        
        } catch (Exception e) {
        }
        
        return idPrestamo;
    }
    
    public ArrayList<Prestamo> prestamosActivos(int idUsuario){
        ArrayList<Prestamo> lista=new ArrayList<>();
        
        try{
            this.sql="SELECT id_prestamo, fecha_sistema FROM prestamo WHERE id_usuario = ? and estado = '1' ORDER BY id_prestamo;";
            ps=this.CN.getConnection().prepareStatement(this.sql);
            ps.setInt(1, idUsuario);
            rs=ps.executeQuery();
            while (rs.next()){
                Prestamo prestamo = new Prestamo();
                prestamo.setIdPrestamo(rs.getInt(1));
                prestamo.setFechaSistema(rs.getDate(2));
                lista.add(prestamo);
            }
        }catch (Exception e){
        }
       
        return lista;
    }
    
    
    @Override
    public String insert(Prestamo objeto) {
        String msj = "";
        this.sql="INSERT INTO prestamo(estado, id_usuario) VALUES (?, ?);";
        
        try {
            ps=this.CN.getConnection().prepareStatement(this.sql);
            ps.setString(1,objeto.getEstado());
            ps.setInt(2,objeto.getIdUsuario());
            int filasAfectadas=ps.executeUpdate();
            
            if(filasAfectadas>0){
                msj = "Insertado exitosamente";
            }
        }catch (Exception e){

        }
        return msj;
        
    }

    @Override
    public String delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(Prestamo objeto) {
        String msj = "";
        this.sql="UPDATE prestamo SET estado = '0' WHERE id_prestamo = ?";
        
        try {
            ps=this.CN.getConnection().prepareStatement(this.sql);
            ps.setInt(1,objeto.getIdPrestamo());
            int filasAfectadas=ps.executeUpdate();
            
            if(filasAfectadas>0){
                msj = "Actualizado exitosamente";
            }
        }catch (Exception e){

        }
        return msj;
    
    }
    
}
