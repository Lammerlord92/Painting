package org.javcarfer.controllers;

import org.javcarfer.domain.Paint;
import org.javcarfer.services.PaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
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

    @GetMapping(value = "paints/{filter}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Paint> findAll(@PathVariable String filter) {
        return service.findAll(filter);
    }

    //Create
    @PostMapping(value = "paints", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Paint> create(@RequestBody Paint paint) {
        return service.create(paint);
    }

    //Update
    @PutMapping(value = "paints", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Paint> update(@RequestBody Paint paint) {
        return service.update(paint);
    }

    //Deleting
    @DeleteMapping(value = "paints", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Paint> delete(@RequestParam("paint") Integer id) {
        return service.delete(id);
    }

}
