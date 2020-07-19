package org.javcarfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring application
 */
@SpringBootApplication
@EnableJpaRepositories
@EntityScan
//@ComponentScan(basePackages = {"org.javcarfer.security"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
