package org.javcarfer.controllers;

import org.javcarfer.domain.Paint;
import org.javcarfer.services.PaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.rmi.transport.ObjectTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

//@CrossOrigin(origins="*")
@CrossOrigin(origins= {"http://localhost:4200"}) //Only angular
@RestController
public class PaintController {
    // Supporting services ----------------------------------------------------
    @Autowired
    private PaintService service;

    // Constructors -----------------------------------------------------------
    public PaintController() {
    }

    // CRUD -------------------------------------------------------------------
    //Get
    @GetMapping(value = "/paints", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Paint> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/paints/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findOne(@PathVariable Integer id) {
        Paint paint=null;
        Map<String, Object> response=new HashMap<>();

        try{
            paint= service.findById(id);
        }catch (DataAccessException e){
            response.put("message", "Database query error");
            response.put("error", e.getCause().getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NoSuchElementException e){
            response.put("message", "The paint doesn't exits");
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Paint>(paint,HttpStatus.OK);
    }

 //   @GetMapping(value = "paints/{filter}", produces = MediaType.APPLICATION_JSON_VALUE)
 //   public List<Paint> findAll(@PathVariable String filter) {
 //       return service.findAll(filter);
 //   }

    //Create
    @PostMapping(value = "/paints", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Paint paint) {
        Paint result=null;
        Map<String, Object> response=new HashMap<>();

        try {
            result=service.create(paint);
        }catch (DataAccessException e){
            response.put("message", "Database query error");
            response.put("error", e.getCause().getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("message","Paint created successfully");
        response.put("paint",result);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
    }

    //Update
    @PutMapping(value = "/paints", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody Paint paint) {
        Paint result=null;
        Map<String, Object> response=new HashMap<>();

        if(paint==null){
            response.put("message", "The paint doesn't exits");
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
        try {
            result=service.update(paint);
        }catch (DataAccessException e){
            response.put("message", "Database query error");
            response.put("error", e.getCause().getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("message","Paint updated successfully");
        response.put("paint",result);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }

    //Deleting
    @DeleteMapping(value = "/paints/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response=new HashMap<>();

        try {
            service.delete(id);
        }catch (DataAccessException e){
            response.put("message", "Database query error");
            response.put("error", e.getCause().getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message","Paint deleted successfully");
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }

}
