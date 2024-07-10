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

    @PostMapping
    public TipoProduto createTipoProduto(@RequestBody TipoProduto tipoProduto) {
        return tipoProdutoService.createTipoProduto(tipoProduto);
    }

    @GetMapping("/{id}")
    public TipoProduto getTipoProduto(@PathVariable Long id) {
        return tipoProdutoService.getTipoProduto(id);
    }

    @GetMapping("/idParceiro/{idParceiro}")
    public List<TipoProduto> getAllTipoProdutos(@PathVariable String idParceiro) {
        return tipoProdutoService.getAllTipoProdutos(idParceiro);
    }

    @PutMapping("/{id}")
    public TipoProduto updateTipoProduto(@RequestBody TipoProduto tipoProduto) {
        return tipoProdutoService.updateTipoProduto(tipoProduto);
    }

    @DeleteMapping("/{id}")
    public void updateTipoProduto(@PathVariable Long id) {
        tipoProdutoService.deleteTipoProduto(id);
    }
}