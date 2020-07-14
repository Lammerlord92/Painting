package org.javcarfer.controllers;

import org.javcarfer.domain.Paint;
import org.javcarfer.services.PaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaintController {
   @Autowired
   private PaintService service;

    //Get
    @GetMapping(value="paints", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Paint> findAll(){ return service.findAll(); }

    @GetMapping(value="paints/{filter}", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Paint> findAll(@PathVariable String filter){
        return service.findAll(filter);
    }

    //Create
    @PostMapping(value="paint",consumes=MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Paint paint){
        service.create(paint);
    }

    //Update
    @PutMapping(value="paint",consumes=MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Paint paint){
        service.update(paint);
    }

    //Deleting
    @DeleteMapping(value="paint",consumes=MediaType.APPLICATION_JSON_VALUE)
    public void deletePaint(@RequestParam("paint") int id){
        service.delete(id);
    }

}
