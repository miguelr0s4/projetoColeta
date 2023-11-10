package com.senac.sistemacoleta.controller;

import com.senac.sistemacoleta.entity.Estado;
import com.senac.sistemacoleta.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public ResponseEntity<List<Estado>> getAllEstados() {
        List<Estado> estados = estadoRepository.findAll();
        return ResponseEntity.ok(estados);
    }

    @GetMapping("/{estadoId}")
    public ResponseEntity<Estado> getEstadoById(@PathVariable Long estadoId) {
        return estadoRepository.findById(estadoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estado> createEstado(@RequestBody Estado estado) {
        Estado createdEstado = estadoRepository.save(estado);
        return ResponseEntity.ok(createdEstado);
    }

    @PutMapping("/{estadoId}")
    public ResponseEntity<Estado> updateEstado(@PathVariable Long estadoId, @RequestBody Estado estado) {
        if (!estadoRepository.existsById(estadoId)) {
            return ResponseEntity.notFound().build();
        }
        estado.setId(estadoId);
        Estado updatedEstado = estadoRepository.save(estado);
        return ResponseEntity.ok(updatedEstado);
    }

    @DeleteMapping("/{estadoId}")
    public ResponseEntity<Void> deleteEstado(@PathVariable Long estadoId) {
        if (!estadoRepository.existsById(estadoId)) {
            return ResponseEntity.notFound().build();
        }
        estadoRepository.deleteById(estadoId);
        return ResponseEntity.noContent().build();
    }
}