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

import com.senac.sistemacoleta.entity.DescarteMaterial;
import com.senac.sistemacoleta.repository.DescarteMaterialRepository;

@RestController
@RequestMapping("/descarteMateriais")
public class DescarteMaterialController {

	@Autowired
	private DescarteMaterialRepository repository;
	
	@GetMapping
	private List<DescarteMaterial> findAll(){
		return repository.findAll();
	}
	
	@PostMapping("/{id}")
	private DescarteMaterial insert(@RequestBody DescarteMaterial descarteMaterial) {
		return repository.save(descarteMaterial);
	}
	
	@PutMapping("/{id}")
	public DescarteMaterial replace(@RequestBody DescarteMaterial newDescarteMaterial, @PathVariable Long id) {
		return repository.findById(id).map(descarteMaterial -> {
			descarteMaterial.setAcordoColeta(newDescarteMaterial.getAcordoColeta());
			descarteMaterial.setDescarte(descarteMaterial.getDescarte());
			descarteMaterial.setImposto(descarteMaterial.getImposto());
			descarteMaterial.setPreco(descarteMaterial.getPreco());
			descarteMaterial.setQuantidade(descarteMaterial.getQuantidade());			
			descarteMaterial.setStatus(descarteMaterial.getStatus());			
			descarteMaterial.setStatusColeta(descarteMaterial.getStatusColeta());			
			return repository.save(descarteMaterial);
		})
		.orElseGet(() -> {
			newDescarteMaterial.setId(id);
			return repository.save(newDescarteMaterial);
		});
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
