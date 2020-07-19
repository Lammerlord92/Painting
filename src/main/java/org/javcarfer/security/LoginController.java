package org.javcarfer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins="*")
@RestController
public class LoginController {

    // Supporting services ----------------------------------------------------

    @Autowired
    LoginService service;

    // Constructors -----------------------------------------------------------

    public LoginController() {
        super();
    }

    // Login ------------------------------------------------------------------

    @GetMapping(value="login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@Valid @ModelAttribute @RequestBody LoginCredentials credentials) {
        Assert.notNull(credentials);
        return "aaaa";
    }


}
