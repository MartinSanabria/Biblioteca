/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelosDAO;

/**
 *
 * @author Alejandro
 */
public interface DML <T>{
    String insert(T objeto);
    String delete(int id);
    String update(T objeto);
}
