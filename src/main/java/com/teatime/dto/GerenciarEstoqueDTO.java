package com.teatime.dto;

import java.math.BigDecimal;
import java.util.Date;

public class GerenciarEstoqueDTO {

    private String idParceiro;
    private String idProduto;
    private String idProdutoItem;
    private Integer qtd;
    private String lote;
    private BigDecimal precoCompra;
    private Date dataValidade;
    private Boolean inUso;

    private String idUsuarioRecebeu;
    private Long idUnidadeDestino;

    public String getIdParceiro() {
        return idParceiro;
    }

    public void setIdParceiro(String idParceiro) {
        this.idParceiro = idParceiro;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public Boolean getInUso() {
        return inUso;
    }

    public void setInUso(Boolean inUso) {
        this.inUso = inUso;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public BigDecimal getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(BigDecimal precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public String getIdProdutoItem() {
        return idProdutoItem;
    }

    public void setIdProdutoItem(String idProdutoItem) {
        this.idProdutoItem = idProdutoItem;
    }

    public String getIdUsuarioRecebeu() {
        return idUsuarioRecebeu;
    }

    public void setIdUsuarioRecebeu(String idUsuarioRecebeu) {
        this.idUsuarioRecebeu = idUsuarioRecebeu;
    }

    public Long getIdUnidadeDestino() {
        return idUnidadeDestino;
    }

    public void setIdUnidadeDestino(Long idUnidadeDestino) {
        this.idUnidadeDestino = idUnidadeDestino;
    }
}
