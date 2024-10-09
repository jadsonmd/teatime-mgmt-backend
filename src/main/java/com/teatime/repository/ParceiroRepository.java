package com.teatime.repository;

import com.teatime.model.Parceiro;
import com.teatime.model.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ParceiroRepository extends JpaRepository<Parceiro, String> {

    @Query("SELECT u FROM Unidade u WHERE u.idParceiro = :idParceiro")
    List<Unidade> findAllUnidades(@PathVariable String idParceiro);

}

