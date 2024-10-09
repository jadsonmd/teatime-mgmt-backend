package com.teatime.controller;

import com.teatime.model.UnidadeMedida;
import com.teatime.service.UnidadeMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/unidades-medida")
public class UnidadeMedidaController {

    @Autowired
    private UnidadeMedidaService unidadeMedidaService;

    @PostMapping
    public ResponseEntity<UnidadeMedida> createUnidadeMedida(@RequestBody UnidadeMedida unidadeMedida) {
        UnidadeMedida createdUnidadeMedida = unidadeMedidaService.createUnidadeMedida(unidadeMedida);
        return new ResponseEntity<>(createdUnidadeMedida, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeMedida> getUnidadeMedida(@PathVariable String id) {
        UnidadeMedida unidadeMedida = unidadeMedidaService.getUnidadeMedida(id);
        return new ResponseEntity<>(unidadeMedida, HttpStatus.OK);
    }

    @GetMapping("/idParceiro/{idParceiro}")
    public ResponseEntity<List<UnidadeMedida>> getAllUnidadesMedida(@PathVariable String idParceiro) {
        List<UnidadeMedida> unidadesMedida = unidadeMedidaService.getAllUnidadesMedida(idParceiro);
        return new ResponseEntity<>(unidadesMedida, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadeMedida> updateUnidadeMedida(@RequestBody UnidadeMedida unidadeMedida) {
        UnidadeMedida updatedUnidadeMedida = unidadeMedidaService.updateUnidadeMedida(unidadeMedida);
        return new ResponseEntity<>(updatedUnidadeMedida, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnidadeMedida(@PathVariable String id) {
        unidadeMedidaService.deleteUnidadeMedida(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}