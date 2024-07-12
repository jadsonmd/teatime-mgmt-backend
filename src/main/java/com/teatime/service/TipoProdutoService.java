package com.teatime.service;

import com.teatime.model.TipoProduto;
import com.teatime.repository.TipoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProdutoService {

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    public TipoProduto createTipoProduto(TipoProduto tipoProduto) {
        return tipoProdutoRepository.save(tipoProduto);
    }

    public TipoProduto getTipoProduto(String id) {
        return tipoProdutoRepository.findById(id).orElse(null);
    }

    public List<TipoProduto> getAllTipoProdutos(String idParceiro) {
        return tipoProdutoRepository.findAllByIdParceiro(idParceiro);
    }

    public TipoProduto updateTipoProduto(TipoProduto tipoProduto) {
        return tipoProdutoRepository.save(tipoProduto);
    }

    public void deleteTipoProduto(String id) {
        tipoProdutoRepository.deleteById(id);
    }
}
