package com.example.backend;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@RestController
public class TestController {

    @PreAuthorize("hasRole('READ')")
    //@Secured({"READ"})
    @GetMapping("/api/read")
    public void read() {
        System.out.println("/api/read");
        return;
    }

    @PreAuthorize("hasRole('CREATE')")
    //@Secured({"CREATE"})
    @GetMapping("/api/create")
    public void create() {
        System.out.println("/api/create");
        return;
    }

    @GetMapping("/api/test")
    public void test(HttpServletRequest req) {
        List<String> headers = Collections.list(req.getHeaderNames());
        System.out.println("Print Headers");
        for (String s : headers) {
            System.out.print(s + " : " + req.getHeader(s) + "\n");
        }
        return;
    }

    @GetMapping("/api/user")
    public String greet(Principal user) {

        return ((OAuth2Authentication) user).getAuthorities().toString();
    }

}
