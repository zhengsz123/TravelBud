package com.travel.core.config;

import com.travel.core.extend.security.MyAuthenticaitonEntrypoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.sun.tools.doclint.Entity.and;
import static org.apache.commons.io.filefilter.FileFilterUtils.and;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAuthenticaitonEntrypoint myAuthenticaitonEntrypoint;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/api/users/**").permitAll()
                .and()
                    .authorizeRequests().antMatchers("/api/**").hasAnyRole("REGISTERED_USER")
                .and()
                    .exceptionHandling().authenticationEntryPoint(myAuthenticaitonEntrypoint)
                .and()
                    .formLogin();
    }
}
