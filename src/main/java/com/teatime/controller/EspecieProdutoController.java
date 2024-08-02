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

    @CrossOrigin
    @PostMapping
    public EspecieProduto createEspecieProduto(@RequestBody EspecieProduto especieProduto) {
        return especieProdutoService.createEspecieProduto(especieProduto);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public EspecieProduto getEspecieProduto(@PathVariable String id) {
        return especieProdutoService.getEspecieProduto(id);
    }

    @CrossOrigin
    @GetMapping("/idParceiro/{idParceiro}")
    public List<EspecieProduto> getAllEspecieProdutos(@PathVariable String idParceiro) {
        return especieProdutoService.getAllEspecieProdutos(idParceiro);
    }

    @CrossOrigin
    @PutMapping
    public EspecieProduto updateEspecieProduto( @RequestBody EspecieProduto especieProduto) {
        return especieProdutoService.updateEspecieProduto(especieProduto);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteEspecieProduto(@PathVariable String id) {
        especieProdutoService.deleteEspecieProduto(id);
    }
}