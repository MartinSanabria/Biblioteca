/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
import java.util.Date; 
/**
 *
 * @author Alejandro
 */
public class Prestamo {
    private int id_prestamo;
    private Date fecha_sistema; // Utiliza Date para representar la fecha
    private String descripcion;
    private int id_usuario;
    private String estado;

    // Constructor para update
    public Prestamo(int id_prestamo, Date fecha_sistema, String descripcion, int id_usuario, String estado) {
        this.id_prestamo = id_prestamo;
        this.fecha_sistema = fecha_sistema;
        this.descripcion = descripcion;
        this.id_usuario = id_usuario;
        this.estado = estado;
    }

    // Constructor para insert
    public Prestamo(int id_usuario, String estado) {
        this.id_usuario = id_usuario;
        this.estado = estado;
    }
    
    // Constructor para delete
    public Prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public Prestamo() {
    }
    
    

    // Getters and Setters
    public int getIdPrestamo() {
        return id_prestamo;
    }

    public void setIdPrestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public Date getFechaSistema() {
        return fecha_sistema;
    }

    public void setFechaSistema(Date fecha_sistema) {
        this.fecha_sistema = fecha_sistema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public Date getFecha_sistema() {
        return fecha_sistema;
    }

    public void setFecha_sistema(Date fecha_sistema) {
        this.fecha_sistema = fecha_sistema;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
