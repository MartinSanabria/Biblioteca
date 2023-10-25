/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Alejandro
 */
public class Usuario {
     private int id_usuario;
    private String nombres;
    private String apellidos;
    private String username;
    private String password_user;
    private String estado;
    private int rol;

    public Usuario() {
    }

    
    // Constructor para update
    public Usuario(int id_usuario, String nombres, String apellidos, String username, String password_user, String estado, int rol) {
        this.id_usuario = id_usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.username = username;
        this.password_user = password_user;
        this.estado = estado;
        this.rol = rol;
    }
    
    // Constructor para insert

    public Usuario(String nombres, String apellidos, String username, String password_user, String estado, int rol) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.username = username;
        this.password_user = password_user;
        this.estado = estado;
        this.rol = rol;
    }

     // Constructor para delete
    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
    
    // Getters and Setters
    public int getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordUser() {
        return password_user;
    }

    public void setPasswordUser(String password_user) {
        this.password_user = password_user;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getPassword_user() {
        return password_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }   

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
}
