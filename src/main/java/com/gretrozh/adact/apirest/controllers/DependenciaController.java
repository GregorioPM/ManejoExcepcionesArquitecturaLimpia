package com.gretrozh.adact.apirest.controllers;

import com.gretrozh.adact.apirest.entities.Dependencia;
import com.gretrozh.adact.apirest.exception.UsuarioNoFound;
import com.gretrozh.adact.apirest.repository.services.IDependenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.PUT})
@RequestMapping("/dependencia")
@Secured("ROLE_ADMIN")
public class DependenciaController {

    @Autowired
    private IDependenciaService dependenciaService;

    @GetMapping("")
    public ResponseEntity<?> listar(){
        List<Dependencia> dependencias = dependenciaService.findAll();
        return  new ResponseEntity<List<Dependencia>>(dependencias, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?>guardar(@RequestBody Dependencia dependencia){
        Map<String, Object> map = new HashMap<String, Object>();
        dependenciaService.save(dependencia);
        return new ResponseEntity<Dependencia>(dependencia,HttpStatus.OK);

        /*try {
            dependenciaService.save(dependencia);
            return new ResponseEntity<Dependencia>(dependencia,HttpStatus.OK);
        }catch (DataAccessException | InternalError e){
            map.put("mensaje", "Error al realizar el insert en la base de datos");
            map.put("error", e.getCause().getMessage());
            return  new ResponseEntity<Map>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> update(@PathVariable int id, @RequestBody Dependencia dependencia){
        return ResponseEntity.ok(dependenciaService.update(dependencia,id));
    }

}
