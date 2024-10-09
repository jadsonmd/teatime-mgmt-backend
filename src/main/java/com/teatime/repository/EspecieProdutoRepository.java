package com.teatime.repository;

import com.teatime.model.EspecieProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface EspecieProdutoRepository  extends JpaRepository<EspecieProduto, String> {

    List<EspecieProduto> findAllByIdParceiro(@PathVariable String idParceiro);

}
