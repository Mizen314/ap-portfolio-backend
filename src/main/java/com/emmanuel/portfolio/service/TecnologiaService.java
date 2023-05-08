package com.emmanuel.portfolio.service;


import com.emmanuel.portfolio.model.Tecnologia;
import com.emmanuel.portfolio.repository.TecnologiasRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class TecnologiaService {
      
    //atributo
    private TecnologiasRepository tecnoRepo;
    private Logger log;
    
    
//contructor
    public TecnologiaService(TecnologiasRepository tecnoRepo){
        this.tecnoRepo = tecnoRepo;
    }
        
   public List<Tecnologia> buscarTodos(){
       return tecnoRepo.findAll();
   }
   
   public ResponseEntity<Tecnologia>agregarTecnologia(@RequestBody Tecnologia tec) {
        //guardar el libro recibido por parámetro en la base de datos
        if(tec.getIdTecno()!=null) {//quiere decir que existe el id y por tanto no es una creación
            return ResponseEntity.badRequest().build();
        }
        Tecnologia result = tecnoRepo.save(tec);
        return ResponseEntity.ok(result); // el liubro devuelto tiene una clave primaria.
    }
   
   
   public ResponseEntity<Tecnologia> buscarUnaTecnologia(Integer id){
       Optional <Tecnologia> tecOpt = tecnoRepo.findById(id);
        if (tecOpt.isPresent())
            return ResponseEntity.ok(tecOpt.get());
        else
            return ResponseEntity.notFound().build();
       
   }
   
    public ResponseEntity<Tecnologia> modifcarTecnologia(Tecnologia tec){
        if(tec.getIdTecno()==null){ // si no tiene id quiere decir ques es una creacion
            log.warn("Se intenta modificar una tecno no creada");
            return ResponseEntity.badRequest().build();          
        } 
        //comprobamos si existe el libro, o si existe con un id erroneo
        if (!tecnoRepo.existsById(tec.getIdTecno())){
            System.out.println("Trying to update a non existant tecno");
            return  ResponseEntity.notFound().build();
        }
      
        //el proceso de actualización
        Tecnologia result = tecnoRepo.save(tec);
        return ResponseEntity.ok(result);// el libro devuelto tiene una clave primaria.
    }
   
   public void borrarTodo(){
       tecnoRepo.deleteAll();
   }
   
   public ResponseEntity<Tecnologia> borrarPorId(Integer id){
       Optional <Tecnologia> tecOpt = tecnoRepo.findById(id);
        if (tecOpt.isPresent()){
            tecnoRepo.deleteById(id);
            return ResponseEntity.ok(tecOpt.get());
        }
        else
            return ResponseEntity.notFound().build();

   }

  
}

