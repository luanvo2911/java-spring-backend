package com.example.demospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
// import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // disable csrf
                .cors(AbstractHttpConfigurer::disable) // disable cors
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/*").permitAll())
                        // .requestMatchers("/*").authenticated())
                // .formLogin(login -> login
                //     .loginPage("/login")
                //     .loginProcessingUrl("/").permitAll()
                // )

        ;
        SecurityFilterChain chain = http.build();
        return chain;

    }

    // @Bean
    // public AuthenticationManager authenticationManager(
    //     UserDetailsService userDetailService,
    //     PasswordEncoder passwordEncoder
    // ) {
    //     DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    //     authenticationProvider.setUserDetailsService(userDetailService);
    //     authenticationProvider.setPasswordEncoder(passwordEncoder);

    //     ProviderManager provideManager = new ProviderManager(authenticationProvider);

    //     return provideManager;
    // }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails userDetails = User
    //             .withUsername("user")
    //             .password("password")
    //             .roles("")
    //             .build();

    //     return new InMemoryUserDetailsManager(userDetails);
    // }

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    // }
}
