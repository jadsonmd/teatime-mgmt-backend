package com.teatime.service;

import com.teatime.model.UnidadeMedida;
import com.teatime.repository.UnidadeMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeMedidaService {

    @Autowired
    private UnidadeMedidaRepository unidadeMedidaRepository;

    public UnidadeMedida createUnidadeMedida(UnidadeMedida unidadeMedida) {
        return unidadeMedidaRepository.save(unidadeMedida);
    }

    public UnidadeMedida getUnidadeMedida(String id) {
        Optional<UnidadeMedida> unidadeMedida = unidadeMedidaRepository.findById(id);
        return unidadeMedida.orElse(null);
    }

    public List<UnidadeMedida> getAllUnidadesMedida(String idParceiro) {
        return unidadeMedidaRepository.findByIdParceiro(idParceiro);
    }

    public UnidadeMedida updateUnidadeMedida(UnidadeMedida unidadeMedida) {
        return unidadeMedidaRepository.save(unidadeMedida);
    }

    public void deleteUnidadeMedida(String id) {
        unidadeMedidaRepository.deleteById(id);
    }
}