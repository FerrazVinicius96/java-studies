package com.livrospringboot.primeiroprogramaspring;

import org.springframework.web.bind.annotation.*;

@RestController
public class PaginaInicial {

    @RequestMapping("/")
    String home(){
        return "Hello Spring Boot!";
    }
}
