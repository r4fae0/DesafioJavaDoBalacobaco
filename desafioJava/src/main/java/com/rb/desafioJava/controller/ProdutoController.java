package com.rb.desafioJava.controller;

import com.rb.desafioJava.model.Produto;
import com.rb.desafioJava.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {


    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    @Operation(summary = "Lista Produtos Cadastrados")
    public List<Produto> findAll(){
        return this.produtoService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Faz a busca pelo usuario responsavel pelo id fornecido e mostra")
    public ResponseEntity<Produto> findById(@PathVariable Long id){

        return produtoService.findById(id)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @Operation(summary = "Cadastra um produto")
    public Produto salvarProduto(@RequestBody Produto produto){
        return this.produtoService.salvarProduto(produto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza o produto que foi passado de acordo com o ID fornecido")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto){
        return this.produtoService.atualizarProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta o produto com base no ID passado")
     public void deletarProdutos(@PathVariable Long id){
        this.produtoService.deletarProdutos(id);
    }
}