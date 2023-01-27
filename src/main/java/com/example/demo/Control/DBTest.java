package com.example.demo.Control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBTest {

    @GetMapping("/db")
    public void dbtest() {

    }
}
