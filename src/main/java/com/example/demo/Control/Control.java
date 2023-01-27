package com.example.demo.Control;

import  org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Control {

    @RequestMapping(value ="/test", method = RequestMethod.POST)
    public @ResponseBody String test(@RequestParam("name") String name){
        System.out.println("/test Requested");
        return "Test Server Running." + name;
    }
}
