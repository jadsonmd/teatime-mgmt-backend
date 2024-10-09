package com.teatime.dto;

import java.math.BigDecimal;

public interface ProdutoItemDTO {

    String getIdProduto();
    String getCodigo();
    String getNome();
    String getMarca();
    BigDecimal getPrecoVenda();
    Integer getEstoqueMin();
    Integer getEstoqueMax();
    Integer getEstoque();
    String getIdTipoProduto();
    String getIdEspecieProduto();
    String getIdFornecedor();
    String getIdUnidadeMedida();

    String getIdProdutoItem();
    String getLote();
    Integer getQuantidade();
    BigDecimal getPrecoCompra();
    String getDataValidade();
    Boolean getInUso();
}
