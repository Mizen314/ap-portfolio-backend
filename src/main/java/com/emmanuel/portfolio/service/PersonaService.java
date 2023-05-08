package com.emmanuel.portfolio.service;


import com.emmanuel.portfolio.model.Persona;
import com.emmanuel.portfolio.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class PersonaService {
      
    //atributo
    private PersonaRepository personaRepository;
    private Logger log;
    
    
//contructor
    public PersonaService(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }
        
   public List<Persona> buscarTodos(){
       return personaRepository.findAll();
   }
   
   public ResponseEntity<Persona>agregarPersona(@RequestBody Persona per) {
        //guardar el libro recibido por parámetro en la base de datos
        if(per.getId()!=null) {//quiere decir que existe el id y por tanto no es una creación
            return ResponseEntity.badRequest().build();
        }
        Persona result = personaRepository.save(per);
        return ResponseEntity.ok(result); // el liubro devuelto tiene una clave primaria.
    }
   
   
   public ResponseEntity<Persona> buscarUnaPersona(Integer id){
       Optional <Persona> perOpt = personaRepository.findById(id);
        if (perOpt.isPresent())
            return ResponseEntity.ok(perOpt.get());
        else
            return ResponseEntity.notFound().build();
       
   }
   
    public ResponseEntity<Persona> modifcarPersona(Persona per){
        if(per.getId()==null){ // si no tiene id quiere decir ques es una creacion
            log.warn("Se intenta modificar un persona no creada");
            return ResponseEntity.badRequest().build();          
        } 
        //comprobamos si existe el libro, o si existe con un id erroneo
        if (!personaRepository.existsById(per.getId())){
            System.out.println("Trying to update a non existant person");
            return  ResponseEntity.notFound().build();
        }
      
        //el proceso de actualización
        Persona result = personaRepository.save(per);
        return ResponseEntity.ok(result);// el libro devuelto tiene una clave primaria.
    }
   
   public void borrarTodo(){
       personaRepository.deleteAll();
   }
   
   public ResponseEntity<Persona> borrarPorId(Integer id){
       Optional <Persona> perOpt = personaRepository.findById(id);
        if (perOpt.isPresent()){
            personaRepository.deleteById(id);
            return ResponseEntity.ok(perOpt.get());
        }
        else
            return ResponseEntity.notFound().build();

   }

  
}

