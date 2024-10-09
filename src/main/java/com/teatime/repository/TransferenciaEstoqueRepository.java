package com.teatime.repository;

import com.teatime.model.TransferenciaEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransferenciaEstoqueRepository extends JpaRepository<TransferenciaEstoque, String> {

    Optional<TransferenciaEstoque> findByIdParceiroAndIdProdutoItemAndIdUnidade(String idParceiro, String idProdutoItem, Long idUnidadeDestino);

    List<TransferenciaEstoque> findByIdParceiroOrderByIdProdutoItemAscIdUnidadeAsc(String idParceiro);

}