package com.emmanuel.portfolio.service;

import com.emmanuel.portfolio.model.Proyecto;
import com.emmanuel.portfolio.repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class ProyectoService {
    
    //atributo
    private ProyectoRepository proyectoRepo;
    private Logger log;
    
    
//contructor
    public ProyectoService(ProyectoRepository proyectoRepo){
        this.proyectoRepo = proyectoRepo;
    }
        
   public List<Proyecto> buscarTodos(){
       return proyectoRepo.findAll();
   }
   
   public ResponseEntity<Proyecto>agregarProyecto(@RequestBody Proyecto proy) {
        //guardar el libro recibido por parámetro en la base de datos
        if(proy.getIdProyecto()!=null) {//quiere decir que existe el id y por tanto no es una creación
            return ResponseEntity.badRequest().build();
        }
        Proyecto result = proyectoRepo.save(proy);
        return ResponseEntity.ok(result); // el liubro devuelto tiene una clave primaria.
    }
   
   
   public ResponseEntity<Proyecto> buscarUnProyecto(Integer id){
       Optional <Proyecto> perOpt = proyectoRepo.findById(id);
        if (perOpt.isPresent())
            return ResponseEntity.ok(perOpt.get());
        else
            return ResponseEntity.notFound().build();
       
   }
   
    public ResponseEntity<Proyecto> modifcarProyecto(Proyecto proy){
        if(proy.getIdProyecto()==null){ // si no tiene id quiere decir ques es una creacion
            log.warn("Se intenta modificar un Proyecto no creadp");
            return ResponseEntity.badRequest().build();          
        } 
        //comprobamos si existe el libro, o si existe con un id erroneo
        if (!proyectoRepo.existsById(proy.getIdProyecto())){
            System.out.println("Trying to update a non existant proyect");
            return  ResponseEntity.notFound().build();
        }
      
        //el proceso de actualización
        Proyecto result = proyectoRepo.save(proy);
        return ResponseEntity.ok(result);// el libro devuelto tiene una clave primaria.
    }
   
   public void borrarTodo(){
       proyectoRepo.deleteAll();
   }
   
   public ResponseEntity<Proyecto> borrarPorId(Integer id){
       Optional <Proyecto> perOpt = proyectoRepo.findById(id);
        if (perOpt.isPresent()){
            proyectoRepo.deleteById(id);
            return ResponseEntity.ok(perOpt.get());
        }
        else
            return ResponseEntity.notFound().build();

   }

  
}

