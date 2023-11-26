package com.senac.sistemacoleta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.sistemacoleta.entity.Rota;
import com.senac.sistemacoleta.repository.RotaRepository;

import jakarta.transaction.Transactional;

@Service
public class RotaService {

    @Autowired
    private RotaRepository repository;

    public List<Rota> listAll() {
        return repository.findAll();
    }

    public Optional<Rota> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Rota save(Rota rota) {
        return repository.save(rota);
    }

    @Transactional
    public Rota update(Rota newRota, Long id) {
        Optional<Rota> rotaOptional = findById(id);
        if(rotaOptional.isPresent()) {
        	Rota rota = rotaOptional.get();
            rota.setInicio(newRota.getInicio());
            rota.setOtimizada(newRota.getOtimizada());
            rota.setStatus(newRota.getStatus());
            rota.setEndereco(newRota.getEndereco());
            return save(rota);
        } else{
        	return null;
        }
    }

    public boolean delete(Long id) {
        Optional<Rota> rotaOptional = findById(id);
        rotaOptional.ifPresent(rota -> repository.delete(rota));
        return rotaOptional.isPresent();
    }
}

