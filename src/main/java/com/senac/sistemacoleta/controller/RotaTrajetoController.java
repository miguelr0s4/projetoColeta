package com.senac.sistemacoleta.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senac.sistemacoleta.entity.RotaTrajeto;
import com.senac.sistemacoleta.repository.RotaTrajetoRepository;

@RestController
@RequestMapping(value = "/rotaTrajetos")
public class RotaTrajetoController {

	@Autowired
	private RotaTrajetoRepository repository;

	@GetMapping
	public List<RotaTrajeto> findAll(){
		return repository.findAll();
	}

	@PostMapping
	public RotaTrajeto insert(@RequestBody RotaTrajeto rotaTrajeto) {
		RotaTrajeto result = repository.save(rotaTrajeto);
		return result;
	}
	
	@PutMapping("/{id}")
	public RotaTrajeto update(@RequestBody RotaTrajeto newRotaTrajeto, @PathVariable Long id) {
		return repository.findById(id).map(rotaTrajeto -> {
			rotaTrajeto.setAcordo(newRotaTrajeto.getAcordo());
			return rotaTrajeto;
		})
		.orElseGet(() -> {
			newRotaTrajeto.setId(id);
			return repository.save(newRotaTrajeto);
		});
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
