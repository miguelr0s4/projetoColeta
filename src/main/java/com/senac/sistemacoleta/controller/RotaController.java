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

import com.senac.sistemacoleta.entity.Rota;
import com.senac.sistemacoleta.repository.RotaRepository;

@RestController
@RequestMapping(value = "rotas")
public class RotaController {

	@Autowired
	private RotaRepository repository;
	
	@GetMapping
	public List<Rota> findAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public Rota insert(@RequestBody Rota rota) {
		Rota result = repository.save(rota);
		return result;
	}
	
	@PutMapping("/{id}")
	public Rota replace(@RequestBody Rota newRota, @PathVariable Long id) {
		return repository.findById(id)
				.map(rota -> {
					rota.setInicio(newRota.getInicio());
					rota.setRotas(newRota.getRotas());
					rota.setOtimizada(newRota.getOtimizada());
					rota.setStatus(newRota.getStatus());
					return repository.save(rota);
				})
				.orElseGet(() -> {
					newRota.setId(id);
					return repository.save(newRota);
				});
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
