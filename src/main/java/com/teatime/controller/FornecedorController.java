package com.teatime.controller;

import com.teatime.model.Fornecedor;
import com.teatime.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Fornecedor> createFornecedor(@RequestBody Fornecedor fornecedor) {
        Fornecedor createdFornecedor = fornecedorService.createFornecedor(fornecedor);
        return new ResponseEntity<>(createdFornecedor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> getFornecedor(@PathVariable String id) {
        Fornecedor fornecedor = fornecedorService.getFornecedor(id);
        return new ResponseEntity<>(fornecedor, HttpStatus.OK);
    }

    @GetMapping("/idParceiro/{idParceiro}")
    public ResponseEntity<List<Fornecedor>> getAllFornecedores(@PathVariable String idParceiro) {
        List<Fornecedor> fornecedores = fornecedorService.getAllFornecedores(idParceiro);
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> updateFornecedor(@RequestBody Fornecedor fornecedor) {
        Fornecedor updatedFornecedor = fornecedorService.updateFornecedor(fornecedor);
        return new ResponseEntity<>(updatedFornecedor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable String id) {
        fornecedorService.deleteFornecedor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}