package org.javcarfer.controllers;

import org.javcarfer.domain.Paint;
import org.javcarfer.services.PaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(value = "paints", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Paint> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "paints/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Paint findOne(@PathVariable Integer id) {return service.findById(id); }

 //   @GetMapping(value = "paints/{filter}", produces = MediaType.APPLICATION_JSON_VALUE)
 //   public List<Paint> findAll(@PathVariable String filter) {
 //       return service.findAll(filter);
 //   }

    //Create
    @PostMapping(value = "paints", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public List<Paint> create(@RequestBody Paint paint) {
        return service.create(paint);
    }

    //Update
    @PutMapping(value = "paints", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Paint update(@RequestBody Paint paint) {
        return service.update(paint);
    }

    //Deleting
    @DeleteMapping(value = "paints", produces = MediaType.APPLICATION_JSON_VALUE)
    public Paint delete(@RequestParam("paint") Integer id) {
        return service.delete(id);
    }

}
