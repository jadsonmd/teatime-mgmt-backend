package com.teatime.dto;

import java.util.Date;

public class TransferirEstoqueDTO {

    private String idParceiro;
    private String idProdutoItem;
    private Long idUnidadeOrigem;
    private Long idUnidadeDestino;
    private Integer quantidade;
    private Date dataTransferencia;
    private String observacao;
    private String idUsuarioTransferiu;
    private String idUsuarioRecebeu;

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

    public Long getIdUnidadeOrigem() {
        return idUnidadeOrigem;
    }

    public void setIdUnidadeOrigem(Long idUnidadeOrigem) {
        this.idUnidadeOrigem = idUnidadeOrigem;
    }

    public Long getIdUnidadeDestino() {
        return idUnidadeDestino;
    }

    public void setIdUnidadeDestino(Long idUnidadeDestino) {
        this.idUnidadeDestino = idUnidadeDestino;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(Date dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getIdUsuarioTransferiu() {
        return idUsuarioTransferiu;
    }

    public void setIdUsuarioTransferiu(String idUsuarioTransferiu) {
        this.idUsuarioTransferiu = idUsuarioTransferiu;
    }

    public String getIdUsuarioRecebeu() {
        return idUsuarioRecebeu;
    }

    public void setIdUsuarioRecebeu(String idUsuarioRecebeu) {
        this.idUsuarioRecebeu = idUsuarioRecebeu;
    }
}
