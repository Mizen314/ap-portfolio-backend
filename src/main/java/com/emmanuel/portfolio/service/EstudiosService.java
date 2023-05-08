
package com.emmanuel.portfolio.service;

import com.emmanuel.portfolio.model.Estudio;
import com.emmanuel.portfolio.repository.EstudiosRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class EstudiosService {
    
    //atributo
    private EstudiosRepository estudiosRepository;
    private Logger log;
    
    
//contructor
    public EstudiosService(EstudiosRepository estudiosRepository){
        this.estudiosRepository = estudiosRepository;
    }
        
public List<Estudio> buscarTodos(){
    return estudiosRepository.findAll();
}

public ResponseEntity<Estudio>agregarEstudio(@RequestBody Estudio est) {
        //guardar el libro recibido por parámetro en la base de datos
        if(est.getIdEstudios()!=null) {//quiere decir que existe el id y por tanto no es una creación
            return ResponseEntity.badRequest().build();
        }
        Estudio result = estudiosRepository.save(est);
        return ResponseEntity.ok(result); // el liubro devuelto tiene una clave primaria.
    }


public ResponseEntity<Estudio> buscarUnEstudio(Integer id){
    Optional <Estudio> estOpt = estudiosRepository.findById(id);
        if (estOpt.isPresent())
            return ResponseEntity.ok(estOpt.get());
        else
            return ResponseEntity.notFound().build();
    
}

    public ResponseEntity<Estudio> modifcarEstudio(Estudio est){
        if(est.getIdEstudios() ==null){ // si no tiene id quiere decir ques es una creacion
            log.warn("Se intenta modificar un estudio no creado");
            return ResponseEntity.badRequest().build();          
        } 
        //comprobamos si existe el libro, o si existe con un id erroneo
        if (!estudiosRepository.existsById(est.getIdEstudios())){
            System.out.println("Trying to update a non existant person");
            return  ResponseEntity.notFound().build();
        }
    
        //el proceso de actualización
        Estudio result = estudiosRepository.save(est);
        return ResponseEntity.ok(result);// el libro devuelto tiene una clave primaria.
    }

public void borrarTodo(){
    estudiosRepository.deleteAll();
}

public ResponseEntity<Estudio> borrarPorId(Integer id){
    Optional <Estudio> perOpt = estudiosRepository.findById(id);
        if (perOpt.isPresent()){
            estudiosRepository.deleteById(id);
            return ResponseEntity.ok(perOpt.get());
        }
        else
            return ResponseEntity.notFound().build();

    }


}


