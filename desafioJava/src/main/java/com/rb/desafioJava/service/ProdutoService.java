package com.rb.desafioJava.service;

import com.rb.desafioJava.model.Produto;
import com.rb.desafioJava.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id){
        return this.produtoRepository.findById(id);
    }

    public Produto salvarProduto(Produto produto){
        return this.produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Long id, Produto produtoNovo){
        Produto prodAntigo = this.produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        prodAntigo.setNome(produtoNovo.getNome());
        prodAntigo.setDescricao(produtoNovo.getDescricao());
        prodAntigo.setPreco(produtoNovo.getPreco());
        prodAntigo.setQtdEstoque(produtoNovo.getQtdEstoque());

        return produtoRepository.save(prodAntigo);
    }

    public void deletarProdutos(Long id){
        this.produtoRepository.deleteById(id);
    }
}