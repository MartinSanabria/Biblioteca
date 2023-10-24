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
        this.edicion = edicion;
        this.estado = estado;
    }
    
    // Constructor para insert

    public Categoria(String nombre, String estado, String edicion) {
        this.nombre = nombre;
        this.edicion = edicion;
        this.estado = estado;
    }
    
    // Constructor para delete

    public Categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    

    // Getters and Setters
    public int getIdCategoria() {
        return id_categoria;
    }

    public void setIdCategoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
