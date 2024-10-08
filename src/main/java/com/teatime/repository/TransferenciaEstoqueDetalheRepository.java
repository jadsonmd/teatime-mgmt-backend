package com.teatime.repository;

import com.teatime.model.TransferenciaEstoqueDetalhe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface TransferenciaEstoqueDetalheRepository extends JpaRepository<TransferenciaEstoqueDetalhe, String> {

    @Query(value = "FROM TransferenciaEstoqueDetalhe detalhe " +
            "JOIN detalhe.transferenciaEstoque transf " +
            "WHERE transf.idParceiro = :idParceiro AND detalhe.tipoMovimentacao = :tipoMovimentacao " +
            "AND detalhe.idUnidadeOrigem IS NOT NULL " +
            "AND detalhe.idUsuarioRecebeu IS NULL " )
    List<TransferenciaEstoqueDetalhe> findAllTransferenciaStockPendenteRecebimento(@PathVariable("idParceiro")String idParceiro, @PathVariable("tipoMovimentacao") String tipoMovimentacao);

    @Query(value = "FROM TransferenciaEstoqueDetalhe detalhe " +
            "JOIN detalhe.transferenciaEstoque transf " +
            "WHERE transf.idProdutoItem = :idProdutoItem " +
            "ORDER BY detalhe.dataTransferencia desc" )
    List<TransferenciaEstoqueDetalhe> getHistoricoMovimentacaoItem(@PathVariable("idProdutoItem") String idProdutoItem);

}