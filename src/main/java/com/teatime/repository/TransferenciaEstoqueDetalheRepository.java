package com.teatime.repository;

import com.teatime.model.TransferenciaEstoqueDetalhe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TransferenciaEstoqueDetalheRepository extends JpaRepository<TransferenciaEstoqueDetalhe, String> {

    @Query(value = "FROM TransferenciaEstoqueDetalhe detalhe " +
            "WHERE detalhe.tipoMovimentacao = :tipoMovimentacao " +
            "AND detalhe.idUnidadeOrigem IS NOT NULL " +
            "AND detalhe.idUsuarioRecebeu IS NULL " )
    List<TransferenciaEstoqueDetalhe> findAllTransferenciaStockPendenteRecebimento(@PathVariable("tipoMovimentacao") String tipoMovimentacao);
}