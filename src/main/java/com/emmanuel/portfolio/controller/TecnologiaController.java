package com.emmanuel.portfolio.controller;

import com.emmanuel.portfolio.model.Tecnologia;
import com.emmanuel.portfolio.service.TecnologiaService;
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
@CrossOrigin(origins="*")
public class TecnologiaController {

//atributo
private TecnologiaService tecnologiaService;

   
public TecnologiaController(TecnologiaService tecnologiaService){
   this.tecnologiaService = tecnologiaService;
}
   @GetMapping("/api/tecnologia")
   @ApiOperation("Ver todos las tecnologia")
   public List<Tecnologia> buscarTodos(){
      return tecnologiaService.buscarTodos();
   }
   @PostMapping("/api/tecnologia")
   @ApiOperation("Cargar un Proyecto")
   public ResponseEntity<Tecnologia>agregarTecnologia(@RequestBody Tecnologia tecno) {    
      return tecnologiaService.agregarTecnologia(tecno);
   }
   
   @GetMapping("/api/tecnologia/{id}")
   @ApiOperation("Buscar una Tecnologia")
   public ResponseEntity<Tecnologia> buscarUnatecnologia(@PathVariable Integer id){
      return tecnologiaService.buscarUnaTecnologia(id);
   
   }
   
   @PutMapping("/api/tecnologia")
   @ApiOperation("Modificar una Tecnologia")
   public ResponseEntity<Tecnologia> modifcarTecnologia(@RequestBody Tecnologia tecno){
      return tecnologiaService.modifcarTecnologia(tecno);
   }
   

   @DeleteMapping("/api/tecnologia/{id}")
   @ApiOperation("Eliminar una Tecnologia con id")
   public ResponseEntity<Tecnologia> borrarPorId(@PathVariable Integer id){
      return tecnologiaService.borrarPorId(id);
   }

}
