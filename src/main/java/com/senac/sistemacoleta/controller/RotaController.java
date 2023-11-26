package com.senac.sistemacoleta.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.sistemacoleta.entity.Rota;
import com.senac.sistemacoleta.service.RotaService;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    @Autowired
    private RotaService service;

    @GetMapping("/list")
    public ResponseEntity<List<Rota>> findAll() {
        List<Rota> rotas = service.listAll();
        return ResponseEntity.ok(rotas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rota> getRota(@PathVariable Long id) {
        Optional<Rota> rota = service.findById(id);
        if(rota.isPresent()) {
	    	return ResponseEntity.ok(rota.get());
	    } else {
	    	return ResponseEntity.notFound().build();
	    }
    }

    @PostMapping
    public ResponseEntity<Rota> insert(@RequestBody Rota newRota) {
        Rota rota = service.save(newRota);
        return ResponseEntity.ok(rota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rota> replace(@RequestBody Rota newRota, @PathVariable Long id) {
        Rota rota = service.update(newRota, id);
        return rota != null ? ResponseEntity.ok(rota) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
