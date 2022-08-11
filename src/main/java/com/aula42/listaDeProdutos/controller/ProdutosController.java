package com.aula42.listaDeProdutos.controller;

import com.aula42.listaDeProdutos.model.ProdutosModel;
import com.aula42.listaDeProdutos.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutosController {

    @Autowired // Injeção de dependência, realiza a ligação
    private ProdutosService produtosService; // Injeção de dependência, realiza a ligação (Significa que repository está ligado a service)

    @GetMapping(path = "/produtos")
    public List<ProdutosModel> buscarTodosProdutos() {
        return produtosService.buscarTodos();
    }

    @GetMapping(path = "/produtos/{codigo}") // A chave identifica que o id faz parte do banco de dados
    public Optional<ProdutosModel> buscarPorId(@PathVariable Long codigo) { // PathVariable indica
        // que o método vai pegar o caminho da variável
        return produtosService.buscarId(codigo);
    }

    @PostMapping(path = "/produtos") // Indica ser um método post
    @ResponseStatus(HttpStatus.CREATED)  //Para retornar uma resposta após o post inserir a informação
    public ProdutosModel cadastrarProdutos(@RequestBody ProdutosModel produtosModel) {
        return produtosService.cadastrar(produtosModel);
    }

    @PutMapping(path = "/produtos/{codigo}") // Não precisa de Optional, pois nunca vai ser vazio
    public ProdutosModel alterarProdutos(@RequestBody ProdutosModel produtosModel) { // O requestbody indica que você precisa dizer
        //Pegar o que vai alterar
        return produtosService.alterar(produtosModel);
    }

    @DeleteMapping(path = "produtos/{codigo}")
    public void deletarProdutos(@PathVariable Long codigo) {
        produtosService.deletar(codigo);
    }
}
