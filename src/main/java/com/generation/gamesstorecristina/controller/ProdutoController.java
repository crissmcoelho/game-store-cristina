package com.generation.gamesstorecristina.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.gamesstorecristina.model.Produto;
import com.generation.gamesstorecristina.repository.CategoriaRepository;
import com.generation.gamesstorecristina.repository.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
			
		return ResponseEntity.ok(produtoRepository.findAll());
		
		// SELECT * FROM tb_postagens;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable("id") Long id){
		return produtoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
				
		// SELECT * FROM tb_postagens WHERE id = ?;
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getByNome(@PathVariable ("nome") String nome){
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));

	}
	
	@PostMapping
	public ResponseEntity<Produto> post(@Valid @RequestBody Produto Produto){
		
		if(categoriaRepository.existsById(Produto.getCategoria().getId())) {
		
			Produto.setId(null);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(Produto));
		}
		
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Tema não existe!", null);
	}
	
	@PutMapping
	public ResponseEntity<Produto> put(@Valid @RequestBody Produto Produto){
		
		if (produtoRepository.existsById(Produto.getId())) {
			
			if(categoriaRepository.existsById(Produto.getCategoria().getId())) {
				
				return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(Produto));
			}
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Tema não existe!", null);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable ("id") Long id) {
		
		Optional<Produto> Produto = produtoRepository.findById(id);
		
		if(Produto.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		produtoRepository.deleteById(id);
	}
	
	@GetMapping("/preco_maior/{preco}")
	public ResponseEntity<List<Produto>> getPrecoMaiorQue(@PathVariable ("preco") BigDecimal preco){ 
		return ResponseEntity.ok(produtoRepository.findByPrecoGreaterThanOrderByPreco(preco));
	}
	
	// Consulta pelo preço menor do que o preço digitado em ordem decrescente
	
	@GetMapping("/preco_menor/{preco}")
	public ResponseEntity<List<Produto>> getPrecoMenorQue(@PathVariable ("preco") BigDecimal preco){ 
		return ResponseEntity.ok(produtoRepository.findByPrecoLessThanOrderByPrecoDesc(preco));
	}
	
}