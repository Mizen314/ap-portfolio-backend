package com.emmanuel.portfolio.controller;

import com.emmanuel.portfolio.model.Proyecto;
import com.emmanuel.portfolio.service.ProyectoService;
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
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
   
//atributo
private ProyectoService proyectoService;

   
public ProyectoController(ProyectoService proyectoService){
   this.proyectoService = proyectoService;
}
   @GetMapping("/api/proyectos")
   @ApiOperation("Ver todos los proyectos")
   public List<Proyecto> buscarTodos(){
       return proyectoService.buscarTodos();
   }
   @PostMapping("/api/proyectos")
   @ApiOperation("Cargar un Proyecto")
   public ResponseEntity<Proyecto>agregarProyecto(@RequestBody Proyecto proy) {    
       return proyectoService.agregarProyecto(proy);
    }
   
   @GetMapping("/api/proyectos/{id}")
   @ApiOperation("Buscar un proyecto")
   public ResponseEntity<Proyecto> buscarUnProyecto(@PathVariable Integer id){
      return proyectoService.buscarUnProyecto(id);
       
   }
   
   @PutMapping("/api/proyectos")
   @ApiOperation("Modificar un proyecto")
    public ResponseEntity<Proyecto> modifcarProyecto(@RequestBody Proyecto proy){
        return proyectoService.modifcarProyecto(proy);
    }
   

   @DeleteMapping("/api/proyectos/{id}")
   @ApiOperation("Eliminar una proyecto con id")
    public ResponseEntity<Proyecto> borrarPorId(@PathVariable Integer id){
        return proyectoService.borrarPorId(id);
   }

}
