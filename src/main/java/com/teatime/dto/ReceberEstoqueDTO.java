package com.teatime.dto;

public class ReceberEstoqueDTO {

    private String idTransferenciaEstoque;
    private String idTransferenciaEstoqueDetalhe;
    private String idUsuarioRecebeu;
    private String observacao;

    public String getIdTransferenciaEstoque() {
        return idTransferenciaEstoque;
    }

    public void setIdTransferenciaEstoque(String idTransferenciaEstoque) {
        this.idTransferenciaEstoque = idTransferenciaEstoque;
    }

    public String getIdUsuarioRecebeu() {
        return idUsuarioRecebeu;
    }

    public void setIdUsuarioRecebeu(String idUsuarioRecebeu) {
        this.idUsuarioRecebeu = idUsuarioRecebeu;
    }

    public String getIdTransferenciaEstoqueDetalhe() {
        return idTransferenciaEstoqueDetalhe;
    }

    public void setIdTransferenciaEstoqueDetalhe(String idTransferenciaEstoqueDetalhe) {
        this.idTransferenciaEstoqueDetalhe = idTransferenciaEstoqueDetalhe;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
