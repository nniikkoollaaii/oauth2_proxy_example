package com.example.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
public class Oauth2ResourceServerExampleConfiguration {

    @Bean
    public ResourceServerConfigurer resourceServerConfigurer() {
        return new ResourceServerConfigurer() {
            @Override
            public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

                //This is used by the oauth2 library as a unique identifier of your microservice.
                // It is used to verify that your service is the intended audience of a given JWT access token.
                resources.resourceId("your-resource-id");
            }

            @Override
            public void configure(HttpSecurity http) throws Exception {
                //http.authorizeRequests().antMatchers("/**").authenticated();
                //The scopes specified here should begin with your resourceId from above.
                http.authorizeRequests()
                        .antMatchers(HttpMethod.GET,"/api/read").access("#oauth2.clientHasRole('testreadrole')")
                        .antMatchers(HttpMethod.GET,"/api/create").access("#oauth2.clientHasRole('testcreaterole')");
            }
        };
    }

}
