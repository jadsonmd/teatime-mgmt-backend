package com.teatime.repository;

import com.teatime.model.EspecieProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EspecieProdutoRepository  extends JpaRepository<EspecieProduto, Long> {

    List<EspecieProduto> findAllByIdParceiro(@PathVariable String idParceiro);

}
