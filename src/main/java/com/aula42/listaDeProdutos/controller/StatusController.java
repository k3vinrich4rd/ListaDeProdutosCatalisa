package com.aula42.listaDeProdutos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// Responsável pela requisição de uma aplicação
//No controller são feitas as requisições, e essas requisições são criadas através de métodos
@RestController //Anotação que é um controller
public class StatusController {

    //Rota por onde vou conseguir acessar esse método
    //localhost:8080 (padrão)
    @GetMapping(path = "/status")
    public String checar(){
        return "Vai dar tudo certo Kevin, confie mais em você!!!";


    }
}
//Repository: responsável pela ligação entre o banco de dados e uma aplicação
