package br.com.gerenciador.moneyger.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciador.moneyger.model.Receita;
import br.com.gerenciador.moneyger.services.ReceitaService;

@RestController
@RequestMapping(value = "/receita")
public class ReceitaResource {

	@Autowired
	private ReceitaService service;
	
	@GetMapping
	public ResponseEntity<List<Receita>> findAll() {
		List<Receita> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Receita> findById(@PathVariable Long id) {
		Receita obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}