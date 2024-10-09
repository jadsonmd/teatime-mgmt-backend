package com.teatime.repository;

import com.teatime.model.TipoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface TipoProdutoRepository extends JpaRepository<TipoProduto, String> {
    List<TipoProduto> findAllByIdParceiro(@PathVariable String idParceiro);
}
