package com.teatime.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(schema = "teatime", name = "transferencia_estoque")
public class TransferenciaEstoque {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @Column(name="ID_PRODUTO_ITEM", nullable = false)
    private String idProdutoItem;

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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PRODUTO_ITEM", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_TRANSFERENCIA_ESTOQUE_PRODUTO_ITEM"))
    private ProdutoItem produtoItem;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_UNIDADE_ORIGEM", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_TRANSFERENCIA_ESTOQUE_UNIDADE_ORIGEM"))
    private Unidade unidadeOrigem;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_UNIDADE_DESTINO", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_TRANSFERENCIA_ESTOQUE_UNIDADE_DESTINO"))
    private Unidade unidadeDestino;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public ProdutoItem getProdutoItem() {
        return produtoItem;
    }

    public void setProdutoItem(ProdutoItem produtoItem) {
        this.produtoItem = produtoItem;
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

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

}