package org.javcarfer.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping(value="greetings/{x}/{y}", produces= MediaType.TEXT_PLAIN_VALUE)
    public String greeting(@PathVariable("x") String x,
                           @PathVariable("y") int y){
        return "Hello again "+x+" "+y;
    }
    //greetings?x="aaaa"
    @GetMapping(value="greetings", produces= MediaType.TEXT_PLAIN_VALUE)
    public String greeting(@RequestParam("x") String x){
        return "Hello again "+x;
    }
}
