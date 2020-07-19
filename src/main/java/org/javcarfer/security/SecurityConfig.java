package org.javcarfer.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override//Get users in the system
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user1")
                .password("{noop}user1")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("{noop}admin")
                .roles("USER","ADMIN");


        /* FOR USERS IN DB
        auth.jdbcAuthentication().dataSource(datasource)
                .usersByUsernameQuery("select username, password, enabled" +
                        " from users where username=?")
                .authoritiesByUsernameQuery("select username, authority" +
                        "from users where username=?");
         */
    }

    @Override //Define security polices
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/paints").hasRole("ADMIN")
                .antMatchers("/paints").authenticated()
                //.antMatchers("/**").authenticated()
                //.antMatchers("/contactos/**").authenticated()
                .and()
                .httpBasic();
    }
}
