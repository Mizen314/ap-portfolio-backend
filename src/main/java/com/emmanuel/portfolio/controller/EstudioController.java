package com.emmanuel.portfolio.controller;

import com.emmanuel.portfolio.model.Estudio;
import com.emmanuel.portfolio.service.EstudiosService;
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
@CrossOrigin(origins = "http://localhost:8081")
public class EstudioController {
   
//atributo
private EstudiosService estudioService;

   
public EstudioController(EstudiosService estudioService){
   this.estudioService = estudioService;
}
   @GetMapping("/api/estudio")
   @ApiOperation("Ver todos los estudios")
   public List<Estudio> buscarTodos(){
       return estudioService.buscarTodos();
   }
   @PostMapping("/api/estudio")
   @ApiOperation("Cargar un estudio")
   public ResponseEntity<Estudio>agregarEstudio(@RequestBody Estudio est) {    
    return estudioService.agregarEstudio(est);
    }
   
   @GetMapping("/api/estudio/{id}")
   @ApiOperation("Buscar un estudio")
   public ResponseEntity<Estudio> buscarUnEstudio(@PathVariable Integer id){
      return estudioService.buscarUnEstudio(id);
       
   }
   
   @PutMapping("/api/estudio")
   @ApiOperation("Modificar un estudio")
    public ResponseEntity<Estudio> modifcarEstudio(@RequestBody Estudio est){
        return estudioService.modifcarEstudio(est);
    }
   

   @DeleteMapping("/api/estudio/{id}")
   @ApiOperation("Eliminar una estudio con id")
    public ResponseEntity<Estudio> borrarPorId(@PathVariable Integer id){
        return estudioService.borrarPorId(id);
   }

}
