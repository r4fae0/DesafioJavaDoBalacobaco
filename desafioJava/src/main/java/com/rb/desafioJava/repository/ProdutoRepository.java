package com.rb.desafioJava.repository;

import com.rb.desafioJava.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
