/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;



import controller.Libro;
import controller.Libreria;
import java.util.ArrayList;

/**
 *
 * @author 2118270
 */
public class servicios {
    ArrayList<Libreria> librerias= new ArrayList();

    public servicios() {
       
       librerias.add(new Libreria(1,"calle 1","132156","alvaro uribe"));
       librerias.add(new Libreria(2,"calle 2","1321564","rojas pinilla"));
       librerias.get(0).addLibro(new Libro( "ana lava la tina", "yo", "es bueno", 1));
    }

    public ArrayList<Libreria> getLibrerias() {
        return librerias;
    }

    public void setLibrerias(ArrayList<Libreria> librerias) {
        this.librerias = librerias;
    }
    
    public Libreria libreiaById(int id){
        Libreria res=null;
        for (Libreria i: librerias) {
            if (i.getID()==id) {
                res=i;
            }
            
        }
        return res;
    }
    
   
}
