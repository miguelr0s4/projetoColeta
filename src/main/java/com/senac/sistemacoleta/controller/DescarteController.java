package com.senac.sistemacoleta.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.sistemacoleta.entity.Descarte;
import com.senac.sistemacoleta.repository.DescarteRepository;

@RestController
@RequestMapping("/descartes")
public class DescarteController {

	@Autowired
	private DescarteRepository repository;
	
	@GetMapping
	public List<Descarte> findAll(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Descarte> getDescarte(@PathVariable Long id) {
	    Optional<Descarte> descarte = repository.findById(id);
	    return descarte;
	}
	
	@PostMapping
	public Descarte insert(@RequestBody Descarte descarte) {
		return repository.save(descarte);
	}
	
	@PutMapping("/{id}")
	public Descarte replace(@RequestBody Descarte newDescarte, @PathVariable Long id) {
		return repository.findById(id).map(descarte -> {
			descarte.setData(newDescarte.getData());
			
			return repository.save(descarte);
		})
		.orElseGet(() -> {
			newDescarte.setId(id);
			return repository.save(newDescarte);
		});
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
