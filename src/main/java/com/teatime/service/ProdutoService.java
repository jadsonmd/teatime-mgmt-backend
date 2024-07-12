package com.teatime.service;

import com.teatime.dto.GerenciarEstoqueDTO;
import com.teatime.dto.ProdutoItemDTO;
import com.teatime.dto.TransferenciaEstoqueDTO;
import com.teatime.enums.TipoMovimentacao;
import com.teatime.model.Produto;
import com.teatime.model.ProdutoItem;
import com.teatime.repository.ProdutoItemRepository;
import com.teatime.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private static final String ID_PARCEIRO = "santo-antonio";

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoItemRepository produtoItemRepository;

    @Autowired
    private TransferenciaEstoqueService transferenciaEstoqueService;

    public Produto createProduto(Produto produto) {
        produto.setEstoque(0);
        return produtoRepository.save(produto);
    }

    public Produto getProduto(String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> getAllProdutos(String idParceiro) {
        return produtoRepository.findByIdParceiroOrderByNomeAsc(idParceiro);
    }

    public List<ProdutoItemDTO> getAllProdutoComItens(String idParceiro) {
        return produtoItemRepository.getAllProdutoComItens(idParceiro);
    }

    public Produto updateProduto(Produto produto) {
        Produto prod = produtoRepository.findById(produto.getId()).orElse(null);
        if (prod != null) {
            produto.setEstoque(prod.getEstoque());
            produto.setCodigo(prod.getCodigo());
            produto.setIdParceiro(prod.getIdParceiro());
        }
        return produtoRepository.save(produto);
    }

    public void deleteProduto(String id) {
        produtoRepository.deleteById(id);
    }

    public Produto incluirStock(GerenciarEstoqueDTO produtoDTO) {
        Optional<Produto> optionalProduto = produtoRepository.findById(produtoDTO.getIdProduto());
        Optional<ProdutoItem> optionalProdutoItem = produtoItemRepository.findByIdProdutoAndLoteAndDataValidade(produtoDTO.getIdProduto(), produtoDTO.getLote(), produtoDTO.getDataValidade());

        if (optionalProdutoItem.isPresent()) {

            optionalProduto.ifPresent(produto -> {
                produto.setEstoque(produto.getEstoque() + produtoDTO.getQtd());
                produtoRepository.save(produto);
            });

            optionalProdutoItem.ifPresent(produtoItem -> {
                produtoItem.setQuantidade(produtoItem.getQuantidade() + produtoDTO.getQtd());
                produtoItem.setPrecoCompra(produtoDTO.getPrecoCompra());
                produtoItemRepository.save(produtoItem);
                transferenciaEstoqueService.createTransferenciaEstoque(new TransferenciaEstoqueDTO(ID_PARCEIRO, produtoItem.getId(), produtoDTO.getIdUsuarioRecebeu(), produtoDTO.getIdUnidadeDestino(), produtoDTO.getQtd(), "Inclusão de estoque", TipoMovimentacao.ENTRADA));
            });

            return optionalProduto.get();
        }

        optionalProduto.ifPresent(produto -> {
            produto.setEstoque(produto.getEstoque() + produtoDTO.getQtd());
            produtoRepository.save(produto);
        });

        ProdutoItem prodItem = new ProdutoItem();
        prodItem.setIdProduto(produtoDTO.getIdProduto());
        prodItem.setLote(produtoDTO.getLote());
        prodItem.setPrecoCompra(produtoDTO.getPrecoCompra());
        prodItem.setQuantidade(produtoDTO.getQtd());
        prodItem.setDataValidade(produtoDTO.getDataValidade());
        prodItem.setInUso(produtoDTO.getInUso());

        produtoItemRepository.save(prodItem);

        transferenciaEstoqueService.createTransferenciaEstoque(new TransferenciaEstoqueDTO(ID_PARCEIRO, prodItem.getId(), produtoDTO.getIdUsuarioRecebeu(), produtoDTO.getIdUnidadeDestino(), produtoDTO.getQtd(), "Inclusão de estoque", TipoMovimentacao.ENTRADA));

        return optionalProduto.get();
    }

    public Produto baixarStock(GerenciarEstoqueDTO produtoDTO) {
        Optional<Produto> optionalProduto = produtoRepository.findById(produtoDTO.getIdProduto());

        optionalProduto.ifPresent(produto -> {
            if (produto.getEstoque() == 0 || (produto.getEstoque() - produtoDTO.getQtd()) < 0) {
                throw new RuntimeException("Produto tem quantidade em estoque igual a 0");
            }

            produtoItemRepository.findById(produtoDTO.getIdProdutoItem()).ifPresent(produtoItem -> {
                if (produtoItem.getQuantidade() == 0 || (produtoItem.getQuantidade() - produtoDTO.getQtd()) < 0) {
                    throw new RuntimeException("Produto item tem quantidade em estoque igual a 0");
                }
                produtoItem.setQuantidade(produtoItem.getQuantidade() - produtoDTO.getQtd());
                produtoItemRepository.save(produtoItem);
                transferenciaEstoqueService.createTransferenciaEstoque(new TransferenciaEstoqueDTO(ID_PARCEIRO, produtoItem.getId(), produtoDTO.getIdUsuarioRecebeu(), produtoDTO.getIdUnidadeDestino(), produtoDTO.getQtd(), "Baixa de estoque", TipoMovimentacao.SAIDA));
            });

            produto.setEstoque(produto.getEstoque() - produtoDTO.getQtd());
            produtoRepository.save(produto);
        });

        return optionalProduto.get();
    }

    public List<ProdutoItem> getAllProdutoItem(String idProduto) {
        return produtoItemRepository.findByIdProduto(idProduto);
    }
}