package com.teatime.service;

import com.teatime.enums.TipoMovimentacao;
import com.teatime.model.TransferenciaEstoque;
import com.teatime.repository.TransferenciaEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransferenciaEstoqueService {

    @Autowired
    private TransferenciaEstoqueRepository transferenciaEstoqueRepository;

    public TransferenciaEstoque createTransferenciaEstoque(String idProdutoItem, Long idUnidadeDestino, Integer quantidade, String observacao, TipoMovimentacao tpMovimentacao) {

        TransferenciaEstoque transferenciaEstoque = new TransferenciaEstoque();
        transferenciaEstoque.setIdProdutoItem(idProdutoItem);
        transferenciaEstoque.setIdUnidadeDestino(idUnidadeDestino);
        transferenciaEstoque.setQuantidade(quantidade);
        transferenciaEstoque.setDataTransferencia(new Date());
        transferenciaEstoque.setTipoMovimentacao(tpMovimentacao.name());
        transferenciaEstoque.setObservacao(observacao);

        return transferenciaEstoqueRepository.save(transferenciaEstoque);
    }

}
