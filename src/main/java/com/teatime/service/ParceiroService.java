package com.teatime.service;

import com.teatime.model.Parceiro;
import com.teatime.model.Unidade;
import com.teatime.repository.ParceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParceiroService {

    @Autowired
    private ParceiroRepository parceiroRepository;

    public Parceiro getUsuarioById(String id) {
        return parceiroRepository.findById(id).orElse(null);
    }

    public List<Unidade> getUnidades(String idParceiro) {
        return parceiroRepository.findAllUnidades(idParceiro);
    }
}