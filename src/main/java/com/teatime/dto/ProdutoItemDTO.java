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
    Long getIdTipoProduto();
    Long getIdEspecieProduto();

    String getIdProdutoItem();
    String getLote();
    Integer getQuantidade();
    BigDecimal getPrecoCompra();
    String getDataValidade();
    Boolean getInUso();
}
