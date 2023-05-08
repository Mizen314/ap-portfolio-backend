package com.emmanuel.portfolio.controller;

import com.emmanuel.portfolio.model.Persona;
import com.emmanuel.portfolio.service.PersonaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
public class PersonaController {
//atributo
private PersonaService personaService;

   
public PersonaController(PersonaService personaService){
   this.personaService = personaService;
}
   @GetMapping("/api/persona")
   @ApiOperation("buscar todas las personas")
   public List<Persona> buscarTodos(){
      return personaService.buscarTodos();
   }
   @PostMapping("/api/persona")
   @ApiOperation("Agregar una persona")
   public ResponseEntity<Persona>agregarPersona(@RequestBody Persona per) {    
   return personaService.agregarPersona(per);
   }
   
   @GetMapping("/api/persona/{id}")
   @ApiOperation("Buscar una persona con id")
   public ResponseEntity<Persona> buscarUnaPersona(@ApiParam("Ingresar el valor de Id") @PathVariable Integer id){
      return personaService.buscarUnaPersona(id);
       
   }
   
   @PutMapping("/api/persona")
   @ApiOperation("Modificar una persona")
    public ResponseEntity<Persona> modifcarPersona(@RequestBody Persona per){
        return personaService.modifcarPersona(per);
    }
   

   @DeleteMapping("/api/persona/{id}")
   @ApiOperation("Eliminar una persona con id")
    public ResponseEntity<Persona> borrarPorId(@PathVariable Integer id){
        return personaService.borrarPorId(id);
   }

}
