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
                    .antMatchers("/leaper/timetable").hasRole("STUDENT")
                    .antMatchers("/leaper/homework").hasRole("STUDENT")
                    .antMatchers("/leaper/registration").permitAll()
                    .antMatchers("/css/**").permitAll()
                    .antMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .logout()
                .logoutUrl("/leaper/logout")
                .logoutSuccessUrl("/leaper/login")
                .and()
                .formLogin()
                    .loginPage("/leaper/login")
                    .defaultSuccessUrl("/leaper/timetable", true).permitAll();
    }

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
