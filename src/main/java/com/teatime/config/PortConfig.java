package com.teatime.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class PortConfig {

    protected void configure(HttpSecurity http) throws Exception {
//        PortMapperImpl portMapper = new PortMapperImpl();
//        portMapper.setPortMappings(Collections.singletonMap("8080", "8080"));
//        PortResolverImpl portResolver = new PortResolverImpl();
//        portResolver.setPortMapper(portMapper);
//        LoginUrlAuthenticationEntryPoint entryPoint = new LoginUrlAuthenticationEntryPoint("api/teatime/login/login");
//        entryPoint.setPortMapper(portMapper);
//        entryPoint.setPortResolver(portResolver);
//        http.exceptionHandling(customizer -> customizer.authenticationEntryPoint(entryPoint));
    }
}