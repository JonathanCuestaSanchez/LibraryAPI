package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LibreriaController {

    static servicios ser = new servicios();

    @GetMapping("/libraries")
    public ResponseEntity<?> getLibrerias() {
         if (ser.getLibrerias()!=null) {
            return new ResponseEntity<>(ser.getLibrerias(),HttpStatus.ACCEPTED );
            
        }else{
            return new ResponseEntity<>("no existe Librerias", HttpStatus.NO_CONTENT);
        }
        
    }
   

    @GetMapping("/libraries/{id}")
    public ResponseEntity<?> getLibreria(@PathVariable int id) {
        if (ser.libreiaById(id)!=null) {
            return new ResponseEntity<>(ser.libreiaById(id),HttpStatus.ACCEPTED);
            
        }else{
            return new ResponseEntity<>("no existe Libreria", HttpStatus.NOT_FOUND);
        }
        

    }
    @GetMapping("/libraries/{id}/books")
    public ResponseEntity<?> getLibros(@PathVariable int id) {
        try {

            return new ResponseEntity<>(ser.libreiaById(id).getLibros(),HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>("no tiene libros", HttpStatus.NO_CONTENT);
        }

    }
     @GetMapping("/libraries/{id}/{book}")
    public ResponseEntity<?> getLibro(@PathVariable int id,@PathVariable int book) {
        if (ser.libreiaById(id).libroByID(book)!=null) {
               return new ResponseEntity<>(ser.libreiaById(id).libroByID(book),HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>("no existe Libro", HttpStatus.NOT_FOUND);
            }

            
    
            
      

    }
    
    @DeleteMapping("/libraries/{id}")
    public ResponseEntity<?> deleteLibraries(@PathVariable int id) {
        
            if (ser.libreiaById(id).getLibros().isEmpty()||ser.libreiaById(id).getLibros()==null) {
                ser.getLibrerias().remove(ser.libreiaById(id));
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>("tiene Libros", HttpStatus.FORBIDDEN);
            }

    }
   @PostMapping("/libraries/{id}/{email}")
    public ResponseEntity<?> manejadorPostRecurso(@RequestBody Libro o,@PathVariable int id,@PathVariable String email) {
        try {
            emailThread f= new emailThread(email,ser,id,o);
            f.start();            
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
           
            return new ResponseEntity<>("no se creo el libro", HttpStatus.NOT_FOUND);
        }

}
    
    
   

}
