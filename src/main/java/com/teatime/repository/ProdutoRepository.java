package com.teatime.repository;

import com.teatime.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByIdParceiroOrderByNomeAsc(String idParceiro);

    @Query("SELECT p FROM Produto p WHERE p.idParceiro = ?1 AND p.estoque <= p.estoqueMin")
    List<Produto> findProdutosAbaixoEstoqueMinimo(String idParceiro);

    @Query("SELECT p FROM Produto p WHERE p.idParceiro = ?1 AND p.estoque >= p.estoqueMax")
    List<Produto> findProdutosAcimaEstoqueMaximo(String idParceiro);

    @Query("SELECT p FROM Produto p WHERE p.idParceiro = ?1 AND p.estoque = 0")
    List<Produto> findProdutosEstoqueZero(String idParceiro);
}