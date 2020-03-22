package com.example.backend;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@RestController
public class TestController {

    //@PreAuthorize("hasRole('testreadrole')")
    @Secured({"testreadrole"})
    @GetMapping("/api/read")
    public void read() {
        System.out.println("/api/read");
        return;
    }

    //@PreAuthorize("hasRole('testcreaterole')")
    @Secured({"testcreaterole"})
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

}
