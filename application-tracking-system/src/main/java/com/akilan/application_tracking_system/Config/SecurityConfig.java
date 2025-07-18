package com.akilan.application_tracking_system.Config;

import com.akilan.application_tracking_system.Filter.JwtAuthFilter;
import com.akilan.application_tracking_system.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.requestMatchers("/authenticate/**").permitAll()
                        .anyRequest().authenticated());

        httpSecurity.addFilterBefore(jwtAuthFilter,
                UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

    /*
     * Customizer<CsrfConfigurer<HttpSecurity>> csfr = new
     * Customizer<CsrfConfigurer<HttpSecurity>>() {
     * 
     * @Override
     * public void customize(CsrfConfigurer<HttpSecurity>
     * httpSecurityCsrfConfigurer) {
     * httpSecurityCsrfConfigurer.disable();
     * }
     * };
     * httpSecurity.csrf(csfr);
     * 
     * Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.
     * AuthorizationManagerRequestMatcherRegistry>
     * auth = new
     * Customizer<AuthorizeHttpRequestsConfigurer<org.springframework.security.
     * config.annotation.web.builders.HttpSecurity>.
     * AuthorizationManagerRequestMatcherRegistry>()
     * {
     * 
     * @Override
     * public void
     * customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.
     * AuthorizationManagerRequestMatcherRegistry
     * authorizationManagerRequestMatcherRegistry) {
     * authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
     * }
     * };
     * 
     * httpSecurity.authorizeHttpRequests(auth);
     * }
     * 
     */

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(daoAuthenticationProvider);
    }
}
