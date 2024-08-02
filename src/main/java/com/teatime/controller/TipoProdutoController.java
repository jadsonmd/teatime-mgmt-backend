package com.teatime.controller;

import com.teatime.model.TipoProduto;
import com.teatime.service.TipoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tipo-produto")
public class TipoProdutoController {

    @Autowired
    private TipoProdutoService tipoProdutoService;

    @CrossOrigin
    @PostMapping
    public TipoProduto createTipoProduto(@RequestBody TipoProduto tipoProduto) {
        return tipoProdutoService.createTipoProduto(tipoProduto);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public TipoProduto getTipoProduto(@PathVariable String id) {
        return tipoProdutoService.getTipoProduto(id);
    }

    @CrossOrigin
    @GetMapping("/idParceiro/{idParceiro}")
    public List<TipoProduto> getAllTipoProdutos(@PathVariable String idParceiro) {
        return tipoProdutoService.getAllTipoProdutos(idParceiro);
    }

    @CrossOrigin
    @PutMapping
    public TipoProduto updateTipoProduto(@RequestBody TipoProduto tipoProduto) {
        return tipoProdutoService.updateTipoProduto(tipoProduto);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void updateTipoProduto(@PathVariable String id) {
        tipoProdutoService.deleteTipoProduto(id);
    }
}