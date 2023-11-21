/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Alejandro
 */
public class Libro {
    private int id_libro;
    private String nombre;
    private String autor;
    private int cantidad;
    private String estado;
    private String foto;
    private int id_categoria;

    public Libro() {
        
    }

    
    // Constructor para update
    public Libro(int id_libro, String nombre, String autor, int cantidad, String foto, int id_categoria, String estado) {
        this.id_libro = id_libro;
        this.nombre = nombre;
        this.autor = autor;
        this.cantidad = cantidad;
        this.foto = foto;
        this.id_categoria = id_categoria;
        this.estado = estado;
    }
    
    // Constructor para insert
    public Libro(String nombre, String autor, int cantidad, String foto, int id_categoria, String estado) {
        this.nombre = nombre;
        this.autor = autor;
        this.cantidad = cantidad;
        this.foto = foto;
        this.id_categoria = id_categoria;
        this.estado = estado;
    }

    public Libro(int id_libro, String nombre, int cantidad, String foto) {
        this.id_libro = id_libro;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.foto = foto;
    }

    public Libro(int id_libro, int cantidad) {
        this.id_libro = id_libro;
        this.cantidad = cantidad;
    }    
    

    // Getters and Setters
    public int getIdLibro() {
        return id_libro;
    }

    public void setIdLibro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getIdCategoria() {
        return id_categoria;
    }

    public void setIdCategoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    
}
