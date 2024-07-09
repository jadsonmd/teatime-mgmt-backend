package com.teatime.controller;

import com.okta.spring.boot.oauth.config.OktaOAuth2Properties;
import com.teatime.dto.GerenciarEstoqueDTO;
import com.teatime.dto.ProdutoItemDTO;
import com.teatime.dto.ReceberEstoqueDTO;
import com.teatime.dto.TransferirEstoqueDTO;
import com.teatime.model.Produto;
import com.teatime.model.ProdutoItem;
import com.teatime.model.TransferenciaEstoque;
import com.teatime.model.TransferenciaEstoqueDetalhe;
import com.teatime.service.ProdutoService;
import com.teatime.service.TransferenciaEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private OktaOAuth2Properties oktaOAuth2Properties;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private TransferenciaEstoqueService transferenciaEstoqueService;

    @CrossOrigin
    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.createProduto(produto);
    }

    @GetMapping("/{id}")
    public Produto getProduto(@PathVariable String id) {
        return produtoService.getProduto(id);
    }

    @CrossOrigin
    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @CrossOrigin
    @GetMapping("/lista-produto-com-itens")
    public List<ProdutoItemDTO> getAllProdutoComItens() {
        return produtoService.getAllProdutoComItens();
    }

    @CrossOrigin
    @GetMapping("/produto-itens/{idProduto}")
    public List<ProdutoItem> getAllProdutoItem(@PathVariable String idProduto) {
        return produtoService.getAllProdutoItem(idProduto);
    }

    @CrossOrigin
    @PutMapping
    public Produto updateProduto(@RequestBody Produto produto) {
        return produtoService.updateProduto(produto);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable String id) {
        produtoService.deleteProduto(id);
    }

    @PostMapping("incluir-stock")
    public Produto incluirStock(@RequestBody GerenciarEstoqueDTO produtoDTO) {
        return produtoService.incluirStock(produtoDTO);
    }

    @PostMapping("baixar-stock")
    public Produto baixarStock(@RequestBody GerenciarEstoqueDTO produtoDTO) {
        return produtoService.baixarStock(produtoDTO);
    }

    @GetMapping("lista-trasferecia-stock")
    public List<TransferenciaEstoque> getAllTransferenciaStock() {
        return transferenciaEstoqueService.getAllTransferenciaStock();
    }

    @GetMapping("lista-trasferecia-stock-pendente-recebimento")
    public List<TransferenciaEstoqueDetalhe> getAllTransferenciaStockPendenteRecebimento() {
        return transferenciaEstoqueService.getAllTransferenciaStockPendenteRecebimento();
    }

    @PostMapping("transferir-stock")
    public TransferenciaEstoque transferirStock(@RequestBody TransferirEstoqueDTO transferirEstoqueDTO) {
        return transferenciaEstoqueService.transferirStock(transferirEstoqueDTO);
    }

    @PostMapping("receber-stock")
    public TransferenciaEstoque receberStock(@RequestBody ReceberEstoqueDTO receberEstoqueDTO) {
        return transferenciaEstoqueService.receberStock(receberEstoqueDTO);
    }

}