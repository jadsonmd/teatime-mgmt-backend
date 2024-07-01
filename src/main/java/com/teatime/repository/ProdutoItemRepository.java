package com.teatime.repository;

import com.teatime.dto.ProdutoItemDTO;
import com.teatime.model.ProdutoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProdutoItemRepository extends JpaRepository<ProdutoItem, String> {

    Optional<ProdutoItem> findByIdProdutoAndLoteAndDataValidade(String idProduto, String lote, Date dataValidade);

    List<ProdutoItem> findByIdProduto(String idProduto);

    @Query("SELECT p.id as idProduto, p.codigo as codigo," +
            " p.nome as nome, p.marca as marca, p.precoVenda as precoVenda," +
            " p.estoqueMin as estoqueMin, p.estoqueMax as estoqueMax," +
            " p.estoque as estoque, p.idTipoProduto as idTipoProduto," +
            " p.idEspecieProduto as idEspecieProduto," +
            " pi.id as idProdutoItem, pi.lote as lote," +
            " pi.quantidade as quantidade," +
            " pi.precoCompra as precoCompra," +
            " pi.dataValidade as dataValidade," +
            " pi.inUso as inUso" +
            " FROM Produto p LEFT JOIN ProdutoItem pi ON pi.idProduto = p.id" +
            " ORDER BY p.nome, p.codigo DESC")
    List<ProdutoItemDTO> getAllProdutoComItens();

}
