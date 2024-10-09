package com.teatime.repository;

import com.teatime.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {
    List<Fornecedor> findByIdParceiro(String idParceiro);
}