package com.emmanuel.portfolio.service;


import com.emmanuel.portfolio.model.Experiencia;
import com.emmanuel.portfolio.repository.ExperienciaLaboralRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class ExperienciaService {
      
    //atributo
    private ExperienciaLaboralRepository expRepo;
    private Logger log;
    
    
//contructor
    public ExperienciaService(ExperienciaLaboralRepository expRepo){
        this.expRepo = expRepo;
    }
        
   public List<Experiencia> buscarTodos(){
       return expRepo.findAll();
   }
   
   public ResponseEntity<Experiencia>agregarExperiencia(@RequestBody Experiencia exp) {
        //guardar el libro recibido por parámetro en la base de datos
        if(exp.getIdExp()!=null) {//quiere decir que existe el id y por tanto no es una creación
            return ResponseEntity.badRequest().build();
        }
        Experiencia result = expRepo.save(exp);
        return ResponseEntity.ok(result); // la exp devuelta tiene una clave primaria.
    }
   
   
   public ResponseEntity<Experiencia> buscarUnaExperiencia(Integer id){
       Optional <Experiencia> expOpt = expRepo.findById(id);
        if (expOpt.isPresent())
            return ResponseEntity.ok(expOpt.get());
        else
            return ResponseEntity.notFound().build();
       
   }
   
    public ResponseEntity<Experiencia> modificarExperiencia(Experiencia exp){
        if(exp.getIdExp()==null){ // si no tiene id quiere decir ques es una creacion
            log.warn("Se intenta modificar un Experiencia no creada");
            return ResponseEntity.badRequest().build();          
        } 
        //comprobamos si existe el libro, o si existe con un id erroneo
        if (!expRepo.existsById(exp.getIdExp())){
            System.out.println("Trying to update a non existant exp");
            return  ResponseEntity.notFound().build();
        }
      
        //el proceso de actualización
        Experiencia result = expRepo.save(exp);
        return ResponseEntity.ok(result);// el libro devuelto tiene una clave primaria.
    }
   
   public void borrarTodo(){
       expRepo.deleteAll();
   }
   
   public ResponseEntity<Experiencia> borrarPorId(Integer id){
       Optional <Experiencia> expOpt = expRepo.findById(id);
        if (expOpt.isPresent()){
            expRepo.deleteById(id);
            return ResponseEntity.ok(expOpt.get());
        }
        else
            return ResponseEntity.notFound().build();

   }

  
}

