package br.com.fiap.synapse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // 1. Libera o Swagger (Documentação)
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                
                // 2. LIBERA APENAS LEITURA (GET) PARA O DASHBOARD/NAVEGADOR
                .requestMatchers(HttpMethod.GET, "/**").permitAll()
                
                // 3. Exige senha para criar/alterar (POST, PUT, DELETE)
                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Cria o usuário "admin" com senha "admin"
        UserDetails user = User.builder()
            .username("admin")
            .password("{noop}admin") // {noop} é obrigatório para senha em texto plano
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }
}