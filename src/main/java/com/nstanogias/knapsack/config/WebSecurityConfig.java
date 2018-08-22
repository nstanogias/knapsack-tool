package com.nstanogias.knapsack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Created by nickstanogias on 22/08/18.
 */
@Component
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {


        auth
                .inMemoryAuthentication().passwordEncoder(passwordEncoder())
                .withUser("admin").password("admin").roles("ADMIN")

        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @Order(1)
    public static class App1ConfigurationAdapter extends WebSecurityConfigurerAdapter {

        private static final String[] AUTH_WHITELIST = {
                // -- swagger ui
                "/v2/api-docs",
                "/swagger-resources",
                "/swagger-resources/**",
                "/configuration/ui",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**",
                "/knapsack/tasks/**",
                "knapsack/solutions/**"
                // other public endpoints of your API may be appended to this array
        };


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll().
                    antMatchers("/knapsack/admin/**").hasRole("ADMIN").anyRequest().authenticated().and()
                    .httpBasic()
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {


            auth
                    .inMemoryAuthentication().passwordEncoder(passwordEncoder())
                    .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")

            ;
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }
}
