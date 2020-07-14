package org.javcarfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"org.javcarfer.controllers"})
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args );
    }
}
