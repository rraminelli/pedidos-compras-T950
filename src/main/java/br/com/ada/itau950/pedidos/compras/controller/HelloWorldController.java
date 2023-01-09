package br.com.ada.itau950.pedidos.compras.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello world!!";
    }

    @GetMapping("/ola-mundo")
    public String olaMundo() {
        return "Ola Mundo!!";
    }

    @PostMapping("/ola-mundo")
    public String olaMundoPost() {
        return "Ola Mundo - POST!!";
    }

}
