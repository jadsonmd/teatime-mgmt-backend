package com.teatime.repository;

import com.teatime.model.TipoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TipoProdutoRepository extends JpaRepository<TipoProduto, String> {
    List<TipoProduto> findAllByIdParceiro(@PathVariable String idParceiro);
}
