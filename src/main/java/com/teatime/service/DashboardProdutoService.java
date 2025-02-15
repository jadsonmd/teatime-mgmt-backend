package com.teatime.service;

import com.teatime.model.Produto;
import com.teatime.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getProdutosAbaixoEstoqueMinimo(String idParceiro) {
        return produtoRepository.findProdutosAbaixoEstoqueMinimo(idParceiro);
    }

    public List<Produto> getProdutosAcimaEstoqueMaximo(String idParceiro) {
        return produtoRepository.findProdutosAcimaEstoqueMaximo(idParceiro);
    }

    public List<Produto> getProdutosEstoqueZero(String idParceiro) {
        return produtoRepository.findProdutosEstoqueZero(idParceiro);
    }
}