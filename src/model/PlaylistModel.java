/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.Icon;

/**
 *
 * @author maula
 */
public class PlaylistModel implements Identificable{
    private int id;
    private String nombre;
    private Icon imagen;
    private int count;

    public PlaylistModel() {
    }

    public PlaylistModel(int id, String nombre, Icon imagen, int count) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.count = count;
    }

    public PlaylistModel(String nombre) {
        this.nombre = nombre;
    }

    public PlaylistModel(String nombre, Icon imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Icon getImagen() {
        return imagen;
    }

    public void setImagen(Icon imagen) {
        this.imagen = imagen;
    }
    
    public int getCount(){
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
}