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

import com.senac.sistemacoleta.entity.AcordoColeta;
import com.senac.sistemacoleta.repository.AcordoColetaRepository;

@RestController
@RequestMapping(value = "/acordo")
public class AcordoColetaController {

	@Autowired
	private AcordoColetaRepository repository;

	@GetMapping
	public List<AcordoColeta> findAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public AcordoColeta insert(@RequestBody AcordoColeta acordo ) {
		return repository.save(acordo);
	}
	
	@PutMapping("/{id}")
	public AcordoColeta replace(@RequestBody AcordoColeta newAcordo, @PathVariable Long id) {
		return repository.findById(id)
				.map(acordo -> {
					acordo.setDataColeta(newAcordo.getDataColeta());
					acordo.setDataSolicitacao(newAcordo.getDataSolicitacao());
					acordo.setRotaTrajeto(newAcordo.getRotaTrajeto());
					return repository.save(acordo);
				})
				.orElseGet(() -> {
					newAcordo.setId(id);
					return repository.save(newAcordo);
				});
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
