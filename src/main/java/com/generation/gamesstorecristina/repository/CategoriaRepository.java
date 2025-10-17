package com.generation.gamesstorecristina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.gamesstorecristina.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	public List<Categoria> findAllByNomeContainingIgnoreCase(String nome);

	
	
	// SELECT * FROM tb_postagens WHERE nome categoria LIKE "%?%";

}
