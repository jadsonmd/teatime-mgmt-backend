package com.teatime.service;

import com.teatime.model.EspecieProduto;
import com.teatime.repository.EspecieProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecieProdutoService {

    @Autowired
    private EspecieProdutoRepository especieProdutoRepository;

    public EspecieProduto createEspecieProduto(EspecieProduto especieProduto) {
        return especieProdutoRepository.save(especieProduto);
    }

    public EspecieProduto getEspecieProduto(String id) {
        return especieProdutoRepository.findById(id).orElse(null);
    }

    public List<EspecieProduto> getAllEspecieProdutos(String idParceiro) {
        return especieProdutoRepository.findAllByIdParceiro(idParceiro);
    }

    public EspecieProduto updateEspecieProduto(EspecieProduto especieProduto) {
        return especieProdutoRepository.save(especieProduto);
    }

    public void deleteEspecieProduto(String id) {
        especieProdutoRepository.deleteById(id);
    }
}
