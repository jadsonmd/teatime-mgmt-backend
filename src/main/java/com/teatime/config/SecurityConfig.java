package com.teatime.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*
        This is where we configure the security required for our endpoints and setup our app to serve as
        an OAuth2 Resource Server, using JWT validation.
        */
        return http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/api/public").permitAll()
                        .requestMatchers("/api/teatime", "/callback").authenticated()
                        .requestMatchers("/api/teatime/prod").hasAuthority("SCOPE_read:messages")
                )
                .cors(Customizer.withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
//                .oauth2Login(oauth2 -> oauth2
//                        .authorizationEndpoint(authorization -> authorization.baseUri("/authorize"))
//                        .redirectionEndpoint(redirection -> redirection.baseUri("/"))
//                        .tokenEndpoint(token -> token.accessTokenResponseClient(new CustomAccessTokenResponseClient()))
//                        .userInfoEndpoint(userInfo -> userInfo.oidcUserService(new OidcUserService()))
//                )
                .build();
    }


}
