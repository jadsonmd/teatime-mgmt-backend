package com.teatime.controller;

import com.teatime.model.Produto;
import com.teatime.service.DashboardProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/dashboard-produto")
public class DashboardProdutoController {

    @Autowired
    private DashboardProdutoService dashboardProdutoService;

    @GetMapping("/abaixo-estoque-minimo/{idParceiro}")
    public ResponseEntity<List<Produto>> getProdutosAbaixoEstoqueMinimo(@PathVariable String idParceiro) {
        List<Produto> produtos = dashboardProdutoService.getProdutosAbaixoEstoqueMinimo(idParceiro);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/acima-estoque-maximo/{idParceiro}")
    public ResponseEntity<List<Produto>> getProdutosAcimaEstoqueMaximo(@PathVariable String idParceiro) {
        List<Produto> produtos = dashboardProdutoService.getProdutosAcimaEstoqueMaximo(idParceiro);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/estoque-zero/{idParceiro}")
    public ResponseEntity<List<Produto>> getProdutosEstoqueZero(@PathVariable String idParceiro) {
        List<Produto> produtos = dashboardProdutoService.getProdutosEstoqueZero(idParceiro);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

}