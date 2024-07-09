package com.teatime.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(schema = "teatime", name = "transferencia_estoque_detalhe")
public class TransferenciaEstoqueDetalhe {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @Column(name="ID_TRANSFERENCIA_ESTOQUE", nullable = false)
    private String idTransferenciaEstoque;

    @Column(name="ID_UNIDADE_ORIGEM", nullable = true)
    private Long idUnidadeOrigem;

    @Column(name="ID_UNIDADE_DESTINO", nullable = false)
    private Long idUnidadeDestino;

    @Column(name="QUANTIDADE", nullable = false)
    private Integer quantidade;

    @Column(name = "DATA_TRANSFERENCIA", nullable = false)
    private Date dataTransferencia;

    @Column(name="OBSERVACAO", nullable = true)
    private String observacao;

    @Column(name = "TIPO_MOVIMENTACAO", nullable = false)
    private String tipoMovimentacao;

    @Column(name="ID_USUARIO_TRANSFERIU", nullable = true)
    private String idUsuarioTransferiu;

    @Column(name="ID_USUARIO_RECEBEU", nullable = true)
    private String idUsuarioRecebeu;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_TRANSFERENCIA_ESTOQUE", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_TRANSFERENCIA_ESTOQUE_DETALHE_TRANSFERENCIA_ESTOQUE"))
    private TransferenciaEstoque transferenciaEstoque;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_UNIDADE_ORIGEM", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_TRANSFERENCIA_ESTOQUE_DETALHE_UNIDADE_ORIGEM"))
    private Unidade unidadeOrigem;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_UNIDADE_DESTINO", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_TRANSFERENCIA_ESTOQUE_DETALHE_UNIDADE_DESTINO"))
    private Unidade unidadeDestino;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_USUARIO_TRANSFERIU", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_TRANSFERENCIA_ESTOQUE_DETALHE_USUARIO_TRANSFERIU"))
    private Usuario usuarioTransferiu;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_USUARIO_RECEBEU", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_TRANSFERENCIA_ESTOQUE_DETALHE_USUARIO_RECEBEU"))
    private Usuario usuarioRecebeu;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdTransferenciaEstoque() {
        return idTransferenciaEstoque;
    }

    public void setIdTransferenciaEstoque(String idTransferenciaEstoque) {
        this.idTransferenciaEstoque = idTransferenciaEstoque;
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

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
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

    public TransferenciaEstoque getTransferenciaEstoque() {
        return transferenciaEstoque;
    }

    public void setTransferenciaEstoque(TransferenciaEstoque transferenciaEstoque) {
        this.transferenciaEstoque = transferenciaEstoque;
    }

    public Unidade getUnidadeOrigem() {
        return unidadeOrigem;
    }

    public void setUnidadeOrigem(Unidade unidadeOrigem) {
        this.unidadeOrigem = unidadeOrigem;
    }

    public Unidade getUnidadeDestino() {
        return unidadeDestino;
    }

    public void setUnidadeDestino(Unidade unidadeDestino) {
        this.unidadeDestino = unidadeDestino;
    }

    public Usuario getUsuarioTransferiu() {
        return usuarioTransferiu;
    }

    public void setUsuarioTransferiu(Usuario usuarioTransferiu) {
        this.usuarioTransferiu = usuarioTransferiu;
    }

    public Usuario getUsuarioRecebeu() {
        return usuarioRecebeu;
    }

    public void setUsuarioRecebeu(Usuario usuarioRecebeu) {
        this.usuarioRecebeu = usuarioRecebeu;
    }
}