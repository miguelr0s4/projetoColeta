package com.senac.sistemacoleta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.sistemacoleta.entity.MaterialTipo;
import com.senac.sistemacoleta.repository.MaterialTipoRepository;

@Service
public class MaterialService {
    @Autowired
    private MaterialTipoRepository materialTipoRepository;

    public List<MaterialTipo> listarMaterialPorIds(List<Long> ids) {
        return materialTipoRepository.findByIdIn(ids);
    }
}
