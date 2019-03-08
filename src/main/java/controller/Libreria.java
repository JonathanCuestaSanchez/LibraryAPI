/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author 2118270
 */
public class Libreria {
    int ID;
    String direccion,telefono,nombre;
    ArrayList<Libro> libros= new ArrayList();

    public Libreria(int ID, String direccion, String telefono, String nombre, ArrayList<Libro> libros) {
        this.ID = ID;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre = nombre;
        this.libros = libros;
    }

    public Libreria(int ID, String direccion, String telefono, String nombre) {
        this.ID = ID;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre = nombre;
    }
    public Libro libroByID(int id){
        Libro res= null;
        for (Libro i: libros) {
            if (i.getId()==id) {
                res=i;
            }
            
        }
        return res;
    }
    
    public void addLibro(Libro libro){
        libros.add(libro);
    }

    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
    
}
