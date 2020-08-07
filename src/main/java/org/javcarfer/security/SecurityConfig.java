package org.javcarfer.security;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.javcarfer.security.users.UserAccount;
import org.javcarfer.security.users.UserAccountRepository;
import org.javcarfer.security.users.UserService;
import org.javcarfer.utilities.PersistenceSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;
import java.io.FileInputStream;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserService();
    };

    @Override//Get users in the system
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(userDetailsService());

    }

    @Override //Define security polices
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                //.antMatchers(HttpMethod.POST,"/paints").hasRole("ADMIN")
                .antMatchers("/paints").anonymous()
                .antMatchers("/paints/**").anonymous()
                .antMatchers("/login").anonymous()
                .antMatchers("/register").anonymous()
                .antMatchers("/**").authenticated()
                //.antMatchers("/contactos/**").authenticated()
                .and()
                .httpBasic();
    }
}
