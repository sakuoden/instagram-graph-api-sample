package sample.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .oauth2Login(configurer -> configurer
                .loginPage("/login")
                .defaultSuccessUrl("/")
            )
            .logout(customizer -> customizer
                .logoutSuccessUrl("/login")
            )
            .authorizeHttpRequests(customizer -> customizer
                .mvcMatchers("/css/**", "/favicon.ico").permitAll()
                .mvcMatchers("/login").permitAll()
                .anyRequest().authenticated()
            )
            .build();
    }
}
