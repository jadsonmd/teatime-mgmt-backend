package com.teatime.repository;

import com.teatime.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByIdParceiroOrderByNomeAsc(String idParceiro);
}