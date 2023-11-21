/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Alejandro
 */
public class Categoria {
     private int id_categoria;
    private String nombre;
    private String estado;
    private String edicion;

    public Categoria() {
    }

    
    // Constructor para update
    public Categoria(int id_categoria, String nombre, String estado, String edicion) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.estado = estado;
        this.edicion = edicion;
        
    }
    
    // Constructor para insert

    public Categoria(String nombre, String estado, String edicion) {
        this.nombre = nombre;
        this.estado = estado;
        this.edicion = edicion;
        
    }

    /**
     * @return the id_categoria
     */
    public int getId_categoria() {
        return id_categoria;
    }

    /**
     * @param id_categoria the id_categoria to set
     */
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the edicion
     */
    public String getEdicion() {
        return edicion;
    }

    /**
     * @param edicion the edicion to set
     */
    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }
    
    
}
