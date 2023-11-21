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
public class CategoriaDAO {

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

    public List ObtenerCategorias() {

        ArrayList<Categoria> lista = new ArrayList<>();
        this.sql = "select * from categoria";
        try {
            ps = this.CN.getConnection().prepareStatement(this.sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId_categoria(rs.getInt("id_categoria"));
                categoria.setNombre(rs.getString("nombre"));
                categoria.setEstado(rs.getString("estado"));
                categoria.setEdicion(rs.getString("edicion"));
                lista.add(categoria);
            }
        } catch (Exception e) {

        }
        return lista;
    }

    public boolean insert(Categoria categoria) {
        this.sql = "insert into categoria(nombre, estado, edicion) values(?,?,?)";

        try {
            ps = this.CN.getConnection().prepareStatement(this.sql);
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getEstado());
            ps.setString(3, categoria.getEdicion());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public boolean actualizar(String categoria, String edicion, int id) {
        this.sql = "update categoria set nombre=?,edicion=? where id_categoria=?";
        try {
            ps = this.CN.getConnection().prepareStatement(this.sql);
            ps.setString(1, categoria);
            ps.setString(2, edicion);
            ps.setInt(3, id);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public boolean eliminar(int id) {
        this.sql = "update categoria set estado=0 where id_categoria=?";
        try {
            ps = this.CN.getConnection().prepareStatement(this.sql);
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public boolean activar(int id) {
        this.sql = "update categoria set estado=1 where id_categoria=?";
        try {
            ps = this.CN.getConnection().prepareStatement(this.sql);
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }
    
    public Categoria buscarPorId(int idcategoria){

       this.sql="select id_categoria, nombre, edicion from categoria where id_categoria=?";
        Categoria categoria=new Categoria();

        try {
            ps = this.CN.getConnection().prepareStatement(this.sql);
            ps.setInt(1, idcategoria);
            rs = ps.executeQuery();

            while (rs.next()){
            categoria.setId_categoria(rs.getInt("id_categoria"));
            categoria.setNombre(rs.getString("nombre"));
            categoria.setEdicion(rs.getString("edicion"));

            }

        } catch (Exception e) {
            e.printStackTrace();  // Agrega esta línea para imprimir la traza de la excepción
        }

        return categoria;
    }

}
