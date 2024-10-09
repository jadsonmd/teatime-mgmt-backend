package com.teatime.service;

import com.teatime.model.Fornecedor;
import com.teatime.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor createFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor getFornecedor(String id) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        return fornecedor.orElse(null);
    }

    public List<Fornecedor> getAllFornecedores(String idParceiro) {
        return fornecedorRepository.findByIdParceiro(idParceiro);
    }

    public Fornecedor updateFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public void deleteFornecedor(String id) {
        fornecedorRepository.deleteById(id);
    }
}