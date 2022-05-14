package com.leaper.securityConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private SecurityService securityService;

    @Autowired
    DataSource dataSource;

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select login as username, password, enabled " +
                        "from users " +
                        "where login = ?")
                .authoritiesByUsernameQuery("select login as username, role " +
                        "from users " +
                        "where login = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("leaper").hasRole("STUDENT")
                    .antMatchers("/css/*")
                .permitAll()
                .anyRequest().authenticated()
                .and()
//                .formLogin().permitAll()
                .formLogin()
                    .loginPage("/leaper/login")
                    .permitAll();
    }

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
