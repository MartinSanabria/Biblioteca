/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Alejandro
 */
public class DetallePrestamo {
     private int id_det_prestamo;
    private int cantidad;
    private int id_libro;
    private int id_prestamo;
    private String estado;

    // Constructor para update
    public DetallePrestamo(int id_det_prestamo, int cantidad, int id_libro, int id_prestamo, String estado) {
        this.id_det_prestamo = id_det_prestamo;
        this.cantidad = cantidad;
        this.id_libro = id_libro;
        this.id_prestamo = id_prestamo;
        this.estado = estado;
    }
    // Constructor para insert
    public DetallePrestamo(int cantidad, int id_libro, int id_prestamo, String estado) {
        this.cantidad = cantidad;
        this.id_libro = id_libro;
        this.id_prestamo = id_prestamo;
        this.estado = estado;
    }
    // Constructor para delete

    public DetallePrestamo(int id_det_prestamo) {
        this.id_det_prestamo = id_det_prestamo;
    }
   
    // Getters and Setters
    public int getIdDetPrestamo() {
        return id_det_prestamo;
    }

    public void setIdDetPrestamo(int id_det_prestamo) {
        this.id_det_prestamo = id_det_prestamo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdLibro() {
        return id_libro;
    }

    public void setIdLibro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getIdPrestamo() {
        return id_prestamo;
    }

    public void setIdPrestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getId_det_prestamo() {
        return id_det_prestamo;
    }

    public void setId_det_prestamo(int id_det_prestamo) {
        this.id_det_prestamo = id_det_prestamo;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
