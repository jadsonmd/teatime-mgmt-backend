package com.teatime.controller;

import com.teatime.model.EspecieProduto;
import com.teatime.service.EspecieProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/especie-produto")
public class EspecieProdutoController {

    @Autowired
    private EspecieProdutoService especieProdutoService;

    @PostMapping
    public EspecieProduto createEspecieProduto(@RequestBody EspecieProduto especieProduto) {
        return especieProdutoService.createEspecieProduto(especieProduto);
    }

    @GetMapping("/{id}")
    public EspecieProduto getEspecieProduto(@PathVariable String id) {
        return especieProdutoService.getEspecieProduto(id);
    }

    @GetMapping("/idParceiro/{idParceiro}")
    public List<EspecieProduto> getAllEspecieProdutos(@PathVariable String idParceiro) {
        return especieProdutoService.getAllEspecieProdutos(idParceiro);
    }

    @PutMapping
    public EspecieProduto updateEspecieProduto( @RequestBody EspecieProduto especieProduto) {
        return especieProdutoService.updateEspecieProduto(especieProduto);
    }

    @DeleteMapping("/{id}")
    public void deleteEspecieProduto(@PathVariable String id) {
        especieProdutoService.deleteEspecieProduto(id);
    }
}