package com.teatime.repository;

import com.teatime.model.TransferenciaEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransferenciaEstoqueRepository extends JpaRepository<TransferenciaEstoque, String> {

    Optional<TransferenciaEstoque> findByIdParceiroAndIdProdutoItemAndIdUnidade(String idParceiro, String idProdutoItem, Long idUnidadeDestino);

    List<TransferenciaEstoque> findByIdParceiroOrderByIdProdutoItemAscIdUnidadeAsc(String idParceiro);

}