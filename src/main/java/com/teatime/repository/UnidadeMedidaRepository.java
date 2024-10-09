package com.teatime.repository;

import com.teatime.model.UnidadeMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadeMedidaRepository extends JpaRepository<UnidadeMedida, String> {
    List<UnidadeMedida> findByIdParceiro(String idParceiro);
}