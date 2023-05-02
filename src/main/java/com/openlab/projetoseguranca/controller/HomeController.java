package com.openlab.projetoseguranca.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/")
    public ResponseBody index() {
        return null;
    }
}
