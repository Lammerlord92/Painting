package org.javcarfer.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping(value="greetings", produces= MediaType.TEXT_PLAIN_VALUE)
    public String greeting(){
        return "Hello again painter!";
    }
}
