package com.emmanuel.portfolio.controller;

import com.emmanuel.portfolio.model.Experiencia;
import com.emmanuel.portfolio.service.ExperienciaService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class ExperienciaController {

//atributo
private ExperienciaService experienciaService;


public ExperienciaController(ExperienciaService experienciaService){
    this.experienciaService = experienciaService;
}
   @GetMapping("/api/experiencia")
   @ApiOperation("Ver todos las experiencias")
   public List<Experiencia> buscarTodos(){
      return experienciaService.buscarTodos();
   }
   @PostMapping("/api/experiencia")
   @ApiOperation("Cargar una experiencia")
   public ResponseEntity<Experiencia>agregarExperiencia(@RequestBody Experiencia exp) {    
       return experienciaService.agregarExperiencia(exp);
    }
   
   @GetMapping("/api/experiencia/{id}")
   @ApiOperation("Buscar una experiencia")
   public ResponseEntity<Experiencia> buscarUnaExperiencia(@PathVariable Integer id){
      return experienciaService.buscarUnaExperiencia(id);
       
   }
   
   @PutMapping("/api/experiencia")
   @ApiOperation("Modificar una experiencia")
    public ResponseEntity<Experiencia> modifcarExperiencia(@RequestBody Experiencia exp){
        return experienciaService.modificarExperiencia(exp);
    }
   

   @DeleteMapping("/api/experiencia/{id}")
   @ApiOperation("Eliminar una experiencia con id")
    public ResponseEntity<Experiencia> borrarPorId(@PathVariable Integer id){
        return experienciaService.borrarPorId(id);
   }

}
