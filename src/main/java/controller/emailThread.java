/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.LibreriaController.ser;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2118270
 */
public class emailThread extends Thread {

    private mail f = new mail();
    String email;
    servicios b;
    int id;
    Libro r;

    public emailThread(String email, servicios b, int id, Libro r) {
        this.email = email;
        this.b = b;
        this.id = id;
        this.r = r;
    }
    

    public void run() {
        try {
            Thread.sleep(60000);
            b.libreiaById(id).addLibro(r);
            f.send(email);
        } catch (InterruptedException ex) {
            Logger.getLogger(emailThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
