package org.javcarfer.controllers;

import org.javcarfer.domain.Paint;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaintController {
    @GetMapping(value="paintTest", produces= MediaType.APPLICATION_JSON_VALUE)
    public Paint paintTest(){
        return new Paint("Gory red","Vallejo","");
    }
}
