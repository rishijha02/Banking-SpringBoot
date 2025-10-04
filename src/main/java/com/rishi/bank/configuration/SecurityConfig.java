package com.rishi.bank.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.rishi.bank.service.BankUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    BankUserDetailsService bankUserDetailsService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // optional, for testing
            .headers(headers -> headers.frameOptions().disable())
            .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/home", "/login", "/register","/h2-console").permitAll()
            .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/employee/**").hasRole("EMPLOYEE")
                .requestMatchers("/customer/**").hasRole("CUSTOMER")
                .anyRequest().authenticated()
            )
             .formLogin(form -> form
                 .loginPage("/login")   // custom login page if you have
                 .defaultSuccessUrl("/", true)
                 .permitAll()
             )
             .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout")
            .invalidateHttpSession(true)   // 🔑 kills session
            .deleteCookies("JSESSIONID")   // 🔑 remove cookie
            .permitAll()
             )
            .sessionManagement(session -> session
                .maximumSessions(1) // only one active session per user
                .maxSessionsPreventsLogin(false)
            )
            .exceptionHandling(ex->ex.accessDeniedPage("/access-denied"));

        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(bankUserDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
