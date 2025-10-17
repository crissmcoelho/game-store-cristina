package com.generation.gamesstorecristina.repository;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.gamesstorecristina.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	// SELECT * FROM tb_postagens WHERE nome produto LIKE "%?%";

	public List <Produto> findByPrecoGreaterThanOrderByPreco(BigDecimal preco); //Busca produtos com preços >

	public List <Produto> findByPrecoLessThanOrderByPrecoDesc(BigDecimal preco); //Busca produtos com preços < 
	
	// SELECT * FROM tb_postagens WHERE nome produto LIKE "%?%";

}
