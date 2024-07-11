package com.teatime.dto;

import com.teatime.enums.TipoMovimentacao;

public class TransferenciaEstoqueDTO {

    private String idParceiro;
    private String idProdutoItem;
    private Integer quantidade;
    private Long idUnidadeDestino;

    private Long idUnidadeOrigem;
    private String idUsuarioRecebeu;
    private String idUsuarioTranferiu;
    private String observacao;
    private TipoMovimentacao tpMovimentacao;

    public TransferenciaEstoqueDTO() {
    }

    public TransferenciaEstoqueDTO(String idParceiro, String idProdutoItem, String idUsuarioRecebeu, Long idUnidadeDestino, Integer quantidade, String observacao, TipoMovimentacao tipoMovimentacao) {
        this.idParceiro = idParceiro;
        this.idProdutoItem = idProdutoItem;
        this.idUsuarioRecebeu = idUsuarioRecebeu;
        this.idUnidadeDestino = idUnidadeDestino;
        this.quantidade = quantidade;
        this.observacao = observacao;
        this.tpMovimentacao = tipoMovimentacao;
    }

    public String getIdParceiro() {
        return idParceiro;
    }

    public void setIdParceiro(String idParceiro) {
        this.idParceiro = idParceiro;
    }

    public String getIdProdutoItem() {
        return idProdutoItem;
    }

    public void setIdProdutoItem(String idProdutoItem) {
        this.idProdutoItem = idProdutoItem;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getIdUnidadeDestino() {
        return idUnidadeDestino;
    }

    public void setIdUnidadeDestino(Long idUnidadeDestino) {
        this.idUnidadeDestino = idUnidadeDestino;
    }

    public Long getIdUnidadeOrigem() {
        return idUnidadeOrigem;
    }

    public void setIdUnidadeOrigem(Long idUnidadeOrigem) {
        this.idUnidadeOrigem = idUnidadeOrigem;
    }

    public String getIdUsuarioRecebeu() {
        return idUsuarioRecebeu;
    }

    public void setIdUsuarioRecebeu(String idUsuarioRecebeu) {
        this.idUsuarioRecebeu = idUsuarioRecebeu;
    }

    public String getIdUsuarioTranferiu() {
        return idUsuarioTranferiu;
    }

    public void setIdUsuarioTranferiu(String idUsuarioTranferiu) {
        this.idUsuarioTranferiu = idUsuarioTranferiu;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public TipoMovimentacao getTpMovimentacao() {
        return tpMovimentacao;
    }

    public void setTpMovimentacao(TipoMovimentacao tpMovimentacao) {
        this.tpMovimentacao = tpMovimentacao;
    }
}
