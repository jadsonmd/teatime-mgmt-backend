package com.teatime.repository;

import com.teatime.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByIdParceiroOrderByNomeAsc(String idParceiro);
}