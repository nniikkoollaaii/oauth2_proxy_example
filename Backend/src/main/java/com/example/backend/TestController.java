package com.example.backend;
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

    @GetMapping("/api/read")
    public void read() {
        return;
    }


    @GetMapping("/api/create")
    public void create() {
        return;
    }

    @GetMapping("/test")
    public void test(HttpServletRequest req) {
        List<String> headers = Collections.list(req.getHeaderNames());
        System.out.print("Print Headers");
        for (String s : headers) {
            System.out.print(s + " : " + req.getHeader(s) + "\n");
        }
        return;
    }

}
