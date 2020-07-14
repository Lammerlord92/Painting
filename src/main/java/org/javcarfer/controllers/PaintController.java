package org.javcarfer.controllers;

import org.javcarfer.domain.Paint;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PaintController {
    List<Paint> paints;
    @PostConstruct //After constructor
    public void init(){
        paints=new ArrayList<>();
        paints.add(new Paint("Iroko","Scale75","SC-27"));
        paints.add(new Paint("Athonian camoshade","Citadel",""));
    }

    @GetMapping(value="paintTest", produces= MediaType.APPLICATION_JSON_VALUE)
    public Paint paintTest(){
        return new Paint("Gory red","Vallejo","");
    }

    @GetMapping(value="paints", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Paint> findAllPaintsTest(){ return paints; }

    @GetMapping(value="paints/{filter}", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Paint> findAllPaintsTest(@PathVariable String filter){
        return paints
                .stream()
                .filter(paint -> paint.getName().contains(filter) || paint.getBranch().contains(filter))
                .collect(Collectors.toList());
    }

}
